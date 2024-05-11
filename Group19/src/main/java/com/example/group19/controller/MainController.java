package com.example.group19.controller;
import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
    @Autowired
    GlobalUserIdService globalUserIdService;

    @RequestMapping("/")
    public String start() {
        return "login";
    }




}
