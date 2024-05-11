package com.example.group19.controller.Admin;


import com.example.group19.model.Course;
import com.example.group19.model.User;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    CourseRepository courseRepo;
    @Autowired
    UserRepository userRepo;

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("courses", courseRepo.findAll());
        return "admin/dashboard";
    }

    @RequestMapping("/course")
    public String course(@RequestParam int id, Model model) {
        Course course = courseRepo.findByCourseId(id);
        List<User> enrolled = userRepo.findByEnrolled(course);
        List<User> completed = userRepo.findByCompleted(course);
        int totalUsers = userRepo.findAll().size();

        model.addAttribute("total", totalUsers);
        model.addAttribute("course", course);
        model.addAttribute("enrolled", enrolled);
        model.addAttribute("completed", completed);

        return "admin/courseInfo";
    }

    @RequestMapping("/user")
    public String user(@RequestParam int id, Model model) {
        User user = userRepo.findById(id);
        List<Course> enrolled = user.getEnrolled();
        List<Course> completed = user.getCompleted();
        int totalCourses = courseRepo.findAll().size();

        model.addAttribute("total", totalCourses);
        model.addAttribute("user", user);
        model.addAttribute("enrolled", enrolled);
        model.addAttribute("completed", completed);

        return "admin/userInfo";
    }
}
