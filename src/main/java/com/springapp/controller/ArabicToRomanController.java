package com.springapp.controller;

import com.springapp.service.ConverterToRomanService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArabicToRomanController {


    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "arabicToRoman", method = RequestMethod.GET)
    public String arabicToRomanGet(Model model){
        return "arabicToRoman";
    }

    @Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 10, multiplier = 2))
    @RequestMapping(value = "arabicToRoman", method = RequestMethod.POST)
    public String arabicToRomanPost(Model model,@RequestParam Integer arabicNumber){
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
