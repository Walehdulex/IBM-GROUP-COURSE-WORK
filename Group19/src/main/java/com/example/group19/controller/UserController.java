package com.example.group19.controller;

import com.example.group19.model.Course;
import com.example.group19.model.User;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository; // Assuming you have a CourseRepository

    @PostMapping("/enrollCourse")
    public ResponseEntity<String> enrollCourse(@RequestBody Map<String, Object> requestBody) {
        Integer courseId = Integer.parseInt(requestBody.get("courseId").toString());
        String id = (String) requestBody.get("id");

        // Find the user by username
        User user = userRepository.findByUsername(id);

        if (user != null) {
            // Find the course by courseId
            Course course = courseRepository.findById(courseId).orElse(null);

            if (course != null) {
                // Add the course to the user's enrolled courses list
                user.getEnrolled().add(course);
                userRepository.save(user);
                return ResponseEntity.ok("Course enrolled successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }


    @PostMapping("/completeCourse")
    public ResponseEntity<String> completeCourse(@RequestBody Map<String, Object> requestBody) {
        Integer courseId = Integer.parseInt(requestBody.get("courseId").toString());
        String id = (String) requestBody.get("id");

        // Find the user by username
        User user = userRepository.findByUsername(id);

        if (user != null) {
            // Find the course by courseId
            Course course = courseRepository.findById(courseId).orElse(null);

            if (course != null) {
                // Remove the course from the user's enrolled courses list
                user.getEnrolled().remove(course);
                // Add the course to the user's completed courses list
                user.getCompleted().add(course);
                userRepository.save(user);
                return ResponseEntity.ok("Course completed successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}
