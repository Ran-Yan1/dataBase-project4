package com.database.bookstore.controller;

import com.database.bookstore.entity.User;
import com.database.bookstore.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/getCheckCode")
    public Object getCheckCode(@RequestBody User user){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        System.out.println(user.getMail());
        try {
            mailService.sendSimpleMail(user.getMail(), "注册验证码", message);
        }catch (Exception e){
            return e.getMessage();
        }
        return checkCode;
    }

}
