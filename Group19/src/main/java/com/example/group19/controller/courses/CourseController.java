package com.example.group19.controller.courses;


import com.example.group19.model.Course;
import com.example.group19.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private boolean courseStarted = false;
    private boolean courseCompleted = false;
    private String completionTime = null;
    @Autowired
    private CourseRepository courseRepository; // Assuming you have a CourseRepository




    @PostMapping("/start")
    public ResponseEntity<String> startCourse() {
        courseStarted = true;
        return ResponseEntity.ok("Course started successfully!");
    }

    @PostMapping("/complete")
    public ResponseEntity<String> completeCourse() {
        if (courseStarted) {
            courseCompleted = true;
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            completionTime = formatter.format(date);

            // Return the trophy HTML along with the completion message
            String trophyHTML = "<h1>Congratulations! You've earned a trophy &#57649</h1>";
            String completionMessage = "Course completed successfully at " + completionTime;
            String responseMessage = trophyHTML + "<br>" + completionMessage;

            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity.badRequest().body("Course not started!");
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, ?>> getCourseStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("started", courseStarted);
        status.put("completed", courseCompleted);
        status.put("completionTime", completionTime);
        return ResponseEntity.ok(status);
    }
    @GetMapping("/courses/link")
    public ResponseEntity<String> getCourseLink(@RequestParam int courseId) {
        System.out.println("Received courseId: " + courseId);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            String courseLink = course.getCourseLink(); // Assuming you have a method getLink() in your Course class
            return ResponseEntity.ok().body(courseLink);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



