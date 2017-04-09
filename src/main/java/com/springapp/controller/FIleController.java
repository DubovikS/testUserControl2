package com.springapp.controller;

import com.springapp.model.User;
import com.springapp.model.UserIp;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class FIleController {

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String listGuests(){
        return "upload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file")MultipartFile file){
        String name = null;
        if(!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();

                String rootPath = "C:\\";
                File dir = new File(rootPath + File.separator + "tmpFiles");

                if(!dir.exists()){
                    dir.mkdirs();
                }

                File uploadFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                return "yes";
            } catch (IOException e) {
                return "error" + e.getMessage();
            }
        }
        else{
            return "error - file is empty";
        }

    }
}
