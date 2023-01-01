package com.example.test.controllers;

import com.example.test.authentication.ManagerUserSession;
import com.example.test.data.UserData;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    ManagerUserSession managerUserSession;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute UserData userData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        UserService.LoginStatus loginStatus = userService.login(userData.getMail(), userData.getPassword());
        System.out.println(userData.getMail());
        System.out.println(userData.getPassword());

        if (loginStatus == UserService.LoginStatus.LOGIN_OK) {

            UserData usuario = userService.findByMail(userData.getMail());
            managerUserSession.logearUsuario(usuario.getId());

            return "index";
        } else if (loginStatus == UserService.LoginStatus.USER_NOT_FOUND) {
            System.out.println("Usuario no encontrado");
            model.addAttribute("error", "No existe usuario");
            return "login";
        } else if (loginStatus == UserService.LoginStatus.ERROR_PASSWORD) {
            System.out.println("Contraseña incorrecta");
            model.addAttribute("error", "Contraseña incorrecta");
            return "login";
        }

        return "login";
    }
}
