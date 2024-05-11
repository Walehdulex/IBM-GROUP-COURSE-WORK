package com.example.group19.controller.login;

import com.example.group19.model.User;
import com.example.group19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class LoginValidator implements Validator{

    private UserRepository repo;
    @Autowired
    public LoginValidator(UserRepository repo) {
        this.repo = repo;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }



    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Enter a username!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Enter a password!");


        List<User> users;
        users = repo.findAll();
        for(int i = 0; i < users.size(); i++){
            if(Objects.equals(user.getUsername(), users.get(i).getUsername())){
                errors.rejectValue("username","","Username is already taken");
                break;
            }



        }
    }


}
