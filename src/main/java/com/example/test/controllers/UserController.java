package com.example.test.controllers;

import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/users")
    public String test() {
        System.out.println(userService.findAll());
        return "index";
    }

}
