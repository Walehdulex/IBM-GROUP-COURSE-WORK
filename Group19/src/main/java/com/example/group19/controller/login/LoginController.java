package com.example.group19.controller.login;

import com.example.group19.controller.login.LoginValidator;
import com.example.group19.model.User;
import com.example.group19.repository.UserRepository;
import com.example.group19.service.GlobalUserIdService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
public class LoginController {
    @Autowired
    GlobalUserIdService globalUserIdService;

    @GetMapping("/login")
    public String login() {
        return "login"; // This will resolve to login.jsp
    }

    @PostMapping("/authenticate")
    public String authenticate(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(userRepo.findByUsername(username) != null && Objects.equals(userRepo.findByUsername(username).getPassword(), password)) {
            User current = new User();
            current = userRepo.findByUsername(username);
            int currentID = current.getId();
            globalUserIdService.setCurrentID(currentID);
            return "redirect:/home?id="+ currentID;
        } else if(userRepo.findByUsername(username) == null){
            model.addAttribute("error","Username doesn't exist");
            return "redirect:/login?error=username";
        }
        else{
            model.addAttribute("error","Password is incorrect");
            return "redirect:/login?error=password";
        }

    }



    @InitBinder
    protected void initbinder(WebDataBinder binder){
        binder.addValidators(new LoginValidator(userRepo));
    }

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/register")
    public String Register(Model model){
        model.addAttribute("user", new User());
        return "register/form";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result,Model model){
        if(result.hasErrors()){
            return "register/form";
        }
        user = userRepo.save(user);
        int currentID = user.getId();
        globalUserIdService.setCurrentID(currentID);
        model.addAttribute("currentUser", user);
        return "redirect:/home?id="+ currentID;
    }

}



