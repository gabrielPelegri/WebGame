package com.example.test.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PlayerModel {

    private String name;
    private Long health;
    private Boolean gameOver;
    private List<CardModel> hand;
    private List<CardModel> deck;
    private Semaphore semaphore;

    public PlayerModel(String name, Long health, ArrayList<CardModel> hand, ArrayList<CardModel> deck) {
        this.name = name;
        this.health = health;
        this.hand = hand;
        this.deck = deck;
        this.semaphore = new Semaphore(1);
    }

    public PlayerModel(UserModel userModel) {
        this.name = userModel.getName();
        this.health = Long.valueOf(30);
        this.hand = new ArrayList<>();
        this.deck = new ArrayList<>();
        this.semaphore = new Semaphore(1);
    }

    public void drawCard() {
        // Check if the player has any cards left in their deck
        if (deck.isEmpty()) {
            // The player's deck is empty, so they cannot draw a card
            System.out.println("You have no more cards left in your deck!");
        } else {
            // Draw a card from the top of the player's deck
            CardModel card = deck.remove(0);

            // Add the drawn card to the player's hand
            hand.add(card);

            // Print a message indicating that the card was drawn
            System.out.println("Drew a " + card.getName() + " card.");
        }
    }

    // Method to play a card from the player's hand
    public void playCard(CardModel card) {
        // Check if the player has the specified card in their hand
        if (this.getHand().contains(card)) {
            // The player does not have the specified card in their hand
            System.out.println("You do not have that card in your hand!");
        } else {
            // Remove the card from the player's hand and play it
            this.getHand().remove(card);
            System.out.println("Played a " + card.getName() + " card.");
        }
    }


    // Method to attack with a card
    public void attackWithCard(CardModel card, CardModel target) {
        // Check if the player has the specified card in their hand
        if (this.getHand().contains(card)) {
            // The player does not have the specified card in their hand
            System.out.println("You do not have that card in your hand!");
        } else {
            // Remove the card from the player's hand and attack with it
            this.getHand().remove(card);
            target.setHealth(target.getHealth() - card.getDamage());
            System.out.println("Attacked with a " + card.getName() + " card.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public List<CardModel> getHand() {
        return hand;
    }

    public void setHand(ArrayList<CardModel> hand) {
        this.hand = hand;
    }

    public List<CardModel> getDeck() {
        return deck;
    }

    public void setDeck(List<CardModel> deck) {
        this.deck = deck;
    }

}
