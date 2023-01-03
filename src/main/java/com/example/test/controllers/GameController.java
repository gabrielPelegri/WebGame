package com.example.test.controllers;

import com.example.test.authentication.ManagerUserSession;
import com.example.test.converters.CardDataToCardModelConverter;
import com.example.test.converters.UserDataToUserModelConverter;
import com.example.test.models.CardModel;
import com.example.test.models.PlayerModel;
import com.example.test.models.UserModel;
import com.example.test.services.CardService;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Controller
public class GameController {

    @Resource
    private UserService userService;

    @Resource
    private CardService cardService;

    @Resource
    private CardDataToCardModelConverter cardDataToCardModelConverter;

    @Resource
    ManagerUserSession managerUserSession;

    @Resource
    private UserDataToUserModelConverter userDataToUserModelConverter;

    @GetMapping("/game")
    public String game() {
        UserModel userModel = userDataToUserModelConverter
                .convert(userService.findById(managerUserSession.usuarioLogeado()));
        PlayerModel playerModel = new PlayerModel(userModel);
        List<CardModel> cardModelList = cardService.findAll();
        Random random = new Random();
        int randomCard = random.nextInt(cardModelList.size());
        for (playerModel.getDeck().size(); playerModel.getDeck().size() < 4; playerModel.getDeck().add(cardModelList.get(randomCard))) {
            randomCard = random.nextInt(5);
        }
        return "game";
    }
}
