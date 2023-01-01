package com.example.test.controllers;

import com.example.test.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/")
    public String Home() {
        return "index";
    }

}
