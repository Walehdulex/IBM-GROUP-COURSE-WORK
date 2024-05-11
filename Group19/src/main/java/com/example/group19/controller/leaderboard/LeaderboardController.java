package com.example.group19.controller.leaderboard;

import com.example.group19.model.User;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class LeaderboardController {
    @Autowired
    GlobalUserIdService globalUserIdService;


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/leaderboard")
    public  String leaderboard(Model model) {
        List<User> users = userRepository.findAll();
    users.sort(Comparator.comparingInt(user -> user.getCoursesCompleted()));
       Collections.reverse(users);
       int currentID = globalUserIdService.getCurrentID();
        model.addAttribute("userID", currentID);
        model.addAttribute("users", users);

        return "leaderboard";

    }

}
