package com.example.group19.controller.courses;


import com.example.group19.model.User;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    GlobalUserIdService globalUserIdService;


    @Autowired
    CourseRepository courseRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        int currentID = globalUserIdService.getCurrentID();
        model.addAttribute("userID", currentID);
        model.addAttribute("courses", courseRepo.findAll());

        return "dashboard";
    }

    @RequestMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("leaderboard", users);
        return "leaderboard";
    }
}
