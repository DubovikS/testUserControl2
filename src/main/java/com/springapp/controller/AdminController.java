package com.springapp.controller;

import com.springapp.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableRetry
public class AdminController {

    @Autowired
    private UserService userService;



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "adminPanel", method = RequestMethod.POST)
    public String listUsers(@RequestParam("passwordInput") String password, Model model){
        model.addAttribute("user", new User());

        if(password.equals("admin")) {
            model.addAttribute("listUsers", this.userService.getAllUsers());
            return "adminPanel";
        }

        else{
            model.addAttribute("listUsers", this.userService.listUsers());
            return "users";
        }
    }

    @Recover
    public String recover(Model model){
        model.addAttribute("user", new User());
        return "users";
    }

    @RequestMapping(value = "adminPanel", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";

    }



}
