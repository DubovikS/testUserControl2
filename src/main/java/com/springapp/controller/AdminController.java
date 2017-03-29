package com.springapp.controller;

import com.springapp.model.User;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

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




}
