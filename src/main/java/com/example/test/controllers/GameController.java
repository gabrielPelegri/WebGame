package com.example.test.controllers;

import com.example.test.authentication.ManagerUserSession;
import com.example.test.converters.CardDataToCardModelConverter;
import com.example.test.converters.UserDataToUserModelConverter;
import com.example.test.models.CardModel;
import com.example.test.models.GameModel;
import com.example.test.models.PlayerModel;
import com.example.test.models.UserModel;
import com.example.test.services.CardService;
import com.example.test.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public String game() throws InterruptedException {
        UserModel userModel = userDataToUserModelConverter
                .convert(userService.findById(managerUserSession.usuarioLogeado()));
        Random random = new Random();
        PlayerModel playerModel = new PlayerModel(userModel);
        PlayerModel playerModel2 = new PlayerModel();
        for (playerModel.getDeck().size(); playerModel.getDeck().size() <= 5; ) {
            CardModel carta=cardService.findAll().get(random.nextInt(cardService.findAll().size()));
            System.out.println("Extraída carta: "+carta.getName());
            playerModel.getDeck().add(carta);
        }
        for (playerModel2.getDeck().size(); playerModel2.getDeck().size() <= 5; ) {
            CardModel carta=cardService.findAll().get(random.nextInt(cardService.findAll().size()));
            System.out.println("Extraída carta: " + carta.getName());
            playerModel2.getDeck().add(carta);
        }
        ArrayList<PlayerModel> players = new ArrayList<>();
        players.add(playerModel);
        players.add(playerModel2);
        gameModel = new GameModel(players);
        gameModel.run();
        return "game";
    }
}
