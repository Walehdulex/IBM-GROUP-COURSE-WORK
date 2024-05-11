package com.example.group19.controller.CourseReview;

import com.example.group19.model.Course;
import com.example.group19.model.CourseReview;
import com.example.group19.model.User;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.CourseReviewRepository;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CourseReviewController {
    @Autowired
    GlobalUserIdService globalUserIdService;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseReviewRepository reviewRepo;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/courses/{courseId}/reviews")
    public String courseReviews(@PathVariable("courseId") int courseId, Model model) {
        User current = new User();
        int currentID = globalUserIdService.getCurrentID();
        Course course = courseRepo.findByCourseId(courseId);
        // Fetch reviews for the selected course from the database
        List<CourseReview> courseReviews = reviewRepo.findByCourse(course);

        model.addAttribute("courseId", courseId);
        model.addAttribute("userID", currentID);
        model.addAttribute("reviews", courseReviews); // Corrected the attribute name to 'courseReviews'
        return "CourseReview/course_review";
    }
    @GetMapping("/courses/{courseId}/reviews")

    public String getCourseReviews(@PathVariable("courseId") int courseId, Model model) {
        User current = new User();
        int currentID = globalUserIdService.getCurrentID();
        // Fetch reviews for the selected course from the database
        Course course = courseRepo.findByCourseId(courseId);
        List<CourseReview> courseReviews = reviewRepo.findByCourse(course);

        model.addAttribute("course", course);
        model.addAttribute("courseId", courseId);
        model.addAttribute("userID", currentID);
        model.addAttribute("reviews", courseReviews); // Corrected the attribute name to 'courseReviews'
        return "CourseReview/course_review";
    }


    @PostMapping("/courses/{courseId}/reviews/user/{userID}")
    public String addReview(@PathVariable("courseId") int courseId,@PathVariable("userID") int userID,
                                                  @RequestParam("reviewText") String reviewText,
                                                  @RequestParam("rating") int rating,
                                                  Model model) {
        User current = new User();
        int currentID = globalUserIdService.getCurrentID();
        current = userRepo.findById(currentID);
        Course course = courseRepo.findByCourseId(courseId);
        CourseReview review = new CourseReview(course,current,reviewText,rating);
        reviewRepo.save(review);
        current.getReviews().add(review);
        userRepo.save(current);
        course.getReviews().add(review);
        courseRepo.save(course);


        return "redirect:/courses/"+ courseId +"/reviews";
    }
}


