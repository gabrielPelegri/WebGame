package com.example.test.controllers;

import com.example.test.authentication.ManagerUserSession;
import com.example.test.data.UserData;
import com.example.test.models.UserModel;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    ManagerUserSession managerUserSession;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, UserData userData) {
        UserService.LoginStatus loginStatus = userService.login(userData.getMail(), userData.getPassword());

        if (loginStatus == UserService.LoginStatus.LOGIN_OK) {
            UserModel usuario = userService.findByEmail(userData.getMail());

            managerUserSession.logearUsuario(usuario.getId());

            return "index";
        } else if (loginStatus == UserService.LoginStatus.USER_NOT_FOUND) {
            model.addAttribute("error", "No existe usuario");
            return "login";
        } else if (loginStatus == UserService.LoginStatus.ERROR_PASSWORD) {
            model.addAttribute("error", "Contraseña incorrecta");
            return "login";
        }

        return "login";
    }
}
