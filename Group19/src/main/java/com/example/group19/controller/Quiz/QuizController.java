package com.example.group19.controller.Quiz;

import com.example.group19.model.Course;
import com.example.group19.model.CourseReview;
import com.example.group19.model.Quiz;
import com.example.group19.model.User;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.QuizRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class QuizController {
    @Autowired
    GlobalUserIdService globalUserIdService;
    @Autowired
    QuizRepository quizRepo;
    @Autowired
    CourseRepository courseRepo;
    @RequestMapping("/courses/{courseId}/quiz")
    public String courseReviews(@PathVariable("courseId") int courseId, Model model) {
        Quiz current = new Quiz();
        current = quizRepo.findByCourseId(courseId);
        int currentID = globalUserIdService.getCurrentID();
        Course course = courseRepo.findByCourseId(courseId);
        model.addAttribute("quiz", current);
        model.addAttribute("courseId", courseId);
        model.addAttribute("userID", currentID);
        model.addAttribute("course", course);

        return "Quiz/quiz";
    }
}
