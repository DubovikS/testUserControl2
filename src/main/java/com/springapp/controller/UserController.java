package com.springapp.controller;

import com.springapp.model.User;
import com.springapp.model.UserIp;
import com.springapp.service.UserIpService;
import com.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserIpService userIpService;
    public UserIpService getUserIpService() {
        return userIpService;
    }
    public void setUserIpService(UserIpService userIpService) {
        this.userIpService = userIpService;
    }


    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        String clientIp = httpServletRequest.getRemoteAddr();
        UserIp userIp = new UserIp();
        userIp.setNumber(clientIp);
        userIp.setTime(new Date().toString() );
        userIpService.updateUser(userIp);

        return "users";
    }

    @Recover
    public String recover(Model model){
        model.addAttribute("user", new User());
        return "users";
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "showAllGuests", method = RequestMethod.GET)
    public String listGuests(Model model){
        model.addAttribute("userIp", new UserIp());
        List<UserIp> list =  this.userIpService.getAllUsers();
        model.addAttribute("listGuests", this.userIpService.getAllUsers());
        return "guests";
    }
}
