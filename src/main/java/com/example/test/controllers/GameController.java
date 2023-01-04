package com.example.test.controllers;

import com.example.test.authentication.ManagerUserSession;
import com.example.test.converters.CardDataToCardModelConverter;
import com.example.test.converters.UserDataToUserModelConverter;
import com.example.test.models.GameModel;
import com.example.test.models.PlayerModel;
import com.example.test.models.UserModel;
import com.example.test.services.CardService;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
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

    GameModel gameModel;
    @GetMapping("/game")
    public String game() {
        UserModel userModel = userDataToUserModelConverter
                .convert(userService.findById(managerUserSession.usuarioLogeado()));
        Random random = new Random();
        PlayerModel playerModel = new PlayerModel(userModel);
        for (playerModel.getDeck().size(); playerModel.getDeck().size() < 5; ) {
            playerModel.getDeck().add(cardService.findAll().get(random.nextInt(cardService.findAll().size())));
        }
        return "game";
    }
}
