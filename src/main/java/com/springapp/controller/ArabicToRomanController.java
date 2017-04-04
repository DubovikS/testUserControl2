package com.springapp.controller;

import com.springapp.model.UserIp;
import com.springapp.service.ConverterToRomanService;
import com.springapp.service.UserIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import  java.util.Date;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArabicToRomanController {

    @Autowired
    private UserIpService userIpService;

    public UserIpService getUserIpService() {
        return userIpService;
    }

    public void setUserIpService(UserIpService userIpService) {
        this.userIpService = userIpService;
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "arabicToRoman", method = RequestMethod.GET)
    public String arabicToRomanGet(Model model, HttpServletRequest httpServletRequest){
        String clientIp = httpServletRequest.getRemoteAddr();
        model.addAttribute("clientIp", clientIp);

        return "arabicToRoman";
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "arabicToRoman", method = RequestMethod.POST)
    public String arabicToRomanPost(Model model,@RequestParam Integer arabicNumber, HttpServletRequest httpServletRequest){
        String clientIp = httpServletRequest.getRemoteAddr();
        model.addAttribute("clientIp", clientIp);
        if(arabicNumber >= 0 && arabicNumber < 4000) {
            ConverterToRomanService converterToRoman = new ConverterToRomanService();
            String result = converterToRoman.ConvertToArabic(arabicNumber);
            model.addAttribute("romanNumber", result);
        }
        else
        {
            model.addAttribute("romanNumber", "Wrong number");
        }
        return "arabicToRoman";
    }
}
