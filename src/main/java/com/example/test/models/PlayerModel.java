package com.example.test.models;

import java.util.ArrayList;

public class PlayerModel {

    private String name;
    private Integer health;
    private ArrayList<CardModel> hand;
    private ArrayList<CardModel> deck;

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
