package com.example.test.models;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class GameModel {
    // Fields to store the players and the current turn number
    private ArrayList<PlayerModel> players;
    private int turnNumber;

    // Field to store the semaphore that controls the flow of the game
    private Semaphore semaphore;

    // Constructor to initialize a new game
    public GameModel(ArrayList<PlayerModel> players) {
        this.players = players;
        this.turnNumber = 0;
        this.semaphore = new Semaphore(1);
    }

    // Method to start the game loop
    public void run() throws InterruptedException {
        // Start the game loop
        while (true) {
            // Acquire the semaphore to take control of the game
            semaphore.acquire();

            // Get the current player
            PlayerModel currentPlayer = players.get(turnNumber % players.size());

            // Prompt the current player to take their turn
            System.out.println(currentPlayer.getName() + ", it's your turn!");

            // Handle the current player's actions
            handleTurn(currentPlayer);

            // Increment the turn number
            turnNumber++;

            // Release the semaphore to allow the next player to take their turn
            semaphore.release();
        }
    }

    // Method to handle a player's turn
    public void handleTurn(PlayerModel player) {
        // Prompt the player to take their actions
        System.out.println("What do you want to do? (1) Draw a card (2) Play a card (3) Attack with a card");

        // Read the player's input and handle the appropriate action
        int action = readInput();
        if (action == 1) {
            player.drawCard();
        } else if (action == 2) {
            // Prompt the player to select a card to play
            System.out.println("Select a card to play:");
            int cardIndex = readInput();
            CardModel card = player.getHand().get(cardIndex);
            player.playCard(card);
        } else if (action == 3) {
            // Prompt the player to select a card to attack with and a target player
            System.out.println("Select a card to attack with:");
            int cardIndex = readInput();
            CardModel card = player.getHand().get(cardIndex);
            System.out.println("Select a target player:");
            int targetIndex = readInput();
            // PlayerModel target = players.get(targetIndex);
            player.attackWithCard(card, players.get(1).getHand().get(targetIndex));
        }
    }

    // Method to read input from the console
    public int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}//end Game class