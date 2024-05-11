package com.example.group19.controller.Admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class adminLoginController {
    @GetMapping("/adminlogin")
    public String login() {
        return "/admin/login";
    }

    /*@PostMapping("/adminlogin")
    public ModelAndView processLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        ModelAndView modelAndView = new ModelAndView();

        if ("admin".equals(username) && "password".equals(password)) {
            modelAndView.setViewName("adminDashboard");
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "Invalid username or password");
        }

        return modelAndView;
    }*/
    @PostMapping("/adminAuthenticate")
    public String adminAuthenticate(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded admin credentials
        final String adminUsername = "admin";
        final String adminPassword = "password";

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            // Assuming you might want to perform some operations for admin after authentication
            // For simplicity, we're directly redirecting to the admin dashboard page
            return "redirect:/admin/dashboard";
        } else {
            // Add error message to model and redirect to login page with an error parameter
            if (!adminUsername.equals(username)) {
                model.addAttribute("error", "Username is incorrect");
                return "redirect:/login?error=username";
            } else {
                model.addAttribute("error", "Password is incorrect");
                return "redirect:/login?error=password";
            }
        }
    }

}

