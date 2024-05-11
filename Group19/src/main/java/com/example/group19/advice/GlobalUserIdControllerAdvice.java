package com.example.group19.advice;

import com.example.group19.service.GlobalUserIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class GlobalUserIdControllerAdvice {

    @Autowired
    GlobalUserIdService globalUserIdService;

    @ModelAttribute("globalUserId")
    public int globalUserId(){
        return globalUserIdService.getCurrentID();
    }
}
