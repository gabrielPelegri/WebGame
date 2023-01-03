package com.example.test.controllers;

import com.example.test.data.UserData;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    @Resource
    UserService userService;

    @RequestMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registro(@ModelAttribute UserData userData) {
        userService.save(userData);
        return "login";
    }
}
