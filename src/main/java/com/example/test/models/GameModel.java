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

    public int jugadorObjetivo(int turnNumber) {
        int jugadorObjetivo = 0;
        if (turnNumber % 2 == 0) {
            jugadorObjetivo = 1;
        } else {
            jugadorObjetivo = 0;
        }
        return jugadorObjetivo;
    }

    // Method to start the game loop
    public void run() throws InterruptedException {
        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Acquire the semaphore to take control of the game
            semaphore.acquire();

            // Get the current player
            PlayerModel currentPlayer = players.get(jugadorObjetivo(turnNumber-1));


            // Prompt the current player to take their turn
            System.out.println(currentPlayer.getName() + ", es tu turno!");

            // Handle the current player's actions
            handleTurn(currentPlayer);

            // Increment the turn number
            turnNumber++;

            // Release the semaphore to allow the next player to take their turn
            semaphore.release();
            if (currentPlayer.getHealth() <= 0 || currentPlayer.getDeck().isEmpty()) {
                gameOver = true;
                System.out.println("El jugador " + currentPlayer.getName() + " ha perdido");
            }
        }
    }

    // Method to handle a player's turn
    public void handleTurn(PlayerModel player) {
        // Prompt the player to take their actions
        System.out.println("¿Qué quieres hacer: (1) Sacar una carta del mazo (2) Jugar una carta (3) Atacar con una carta");

        // Read the player's input and handle the appropriate action
        int action = readInput();
        if (action == 1) {
            player.drawCard();
        } else if (action == 2) {
            // Prompt the player to select a card to play
            System.out.println("Elije qué carta jugar: ");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.println("(" + (i) + ") " + player.getHand().get(i).getName());
            }
            int cardIndex = readInput();
            CardModel card = player.getHand().get(cardIndex);
            player.playCard(card);
        } else if (action == 3) {
            // Prompt the player to select a card to attack with and a target player
            System.out.println("Elije una carta con la que atacar: ");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.println("(" + (i) + ") " + player.getHand().get(i).getName());
            }
            int cardIndex = readInput();
            CardModel card = player.getHand().get(cardIndex);
            System.out.println("Elije qué carta atacar: ");
            for (int i = 0; i < players.get(jugadorObjetivo(turnNumber)).getHand().size(); i++) {
                System.out.println("(" + (i) + ") " + players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getName());
            }
            int targetIndex = readInput();
            // PlayerModel target = players.get(targetIndex);
            player.attackWithCard(card, players.get(jugadorObjetivo(turnNumber)).getHand().get(targetIndex));
            // System.out.println("El jugador" + jugadorObjetivo(turnNumber) + "ha perdido " + card.getDamage() + "puntos de vida");
            System.out.println("La carta " + card.getName() + " ha atacado a la carta " + players.get(jugadorObjetivo(turnNumber)).getHand().get(targetIndex).getName());
            for (int i = 0; i < players.get(jugadorObjetivo(turnNumber)).getHand().size(); i++) {
                if (players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getHealth() <= 0L) {
                    System.out.println("La carta " + players.get(jugadorObjetivo(turnNumber)).getHand().get(i).getName() + " ha muerto");
                    players.get(jugadorObjetivo(turnNumber)).getHand().remove(i);
                    players.get(jugadorObjetivo(turnNumber)).setHealth(players.get(jugadorObjetivo(turnNumber)).getHealth() - 10L);
                }
            }
        }
    }


    // Method to read input from the console
    public int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}