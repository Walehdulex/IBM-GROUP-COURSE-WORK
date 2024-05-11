package com.example.group19.controller;

import com.example.group19.model.User;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    GlobalUserIdService globalUserIdService;


    @Autowired
    private UserRepository userRepo;
    @GetMapping("/home")
    public String showHomePage(@RequestParam int id, Model model) {
        User current = new User();
        current = userRepo.findById(id);
        int currentID = globalUserIdService.getCurrentID();
        model.addAttribute("userID", currentID);
        model.addAttribute("currentUser", current);
        model.addAttribute("enrolled", current.getEnrolled());
        model.addAttribute("completed", current.getCompleted());
        return "home";
    }
}
