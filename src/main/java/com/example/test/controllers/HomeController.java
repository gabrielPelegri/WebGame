package com.example.test.controllers;

import com.example.test.models.CardModel;
import com.example.test.services.CardService;
import com.example.test.services.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private CardService cardService;

    @RequestMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "Inicio";
    }

    @ResponseBody
    @GetMapping("/cards")
    public List<CardModel> cards() {
        return cardService.findAll().stream().map(cardModel -> {
            cardModel.getName();
            return cardModel;
        }).collect(Collectors.toList());
    }
}
