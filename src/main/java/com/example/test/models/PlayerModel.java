package com.example.test.models;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class PlayerModel {

    private String name;
    private Integer health;
    private ArrayList<CardModel> hand;
    private ArrayList<CardModel> deck;
    private Semaphore semaphore;

    public PlayerModel(String name, Integer health, ArrayList<CardModel> hand, ArrayList<CardModel> deck) {
        this.name = name;
        this.health = health;
        this.hand = hand;
        this.deck = deck;
        this.semaphore = new Semaphore(1);
    }
    public PlayerModel(UserModel userModel) {
        this.name = userModel.getName();
        this.health = 30;
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.semaphore = new Semaphore(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public ArrayList<CardModel> getHand() {
        return hand;
    }

    public void setHand(ArrayList<CardModel> hand) {
        this.hand = hand;
    }

    public ArrayList<CardModel> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<CardModel> deck) {
        this.deck = deck;
    }

}
