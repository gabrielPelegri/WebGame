package com.example.test.controllers;

import com.example.test.data.UserData;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<UserData> test() {
       return userService.findAll();
    }

}
