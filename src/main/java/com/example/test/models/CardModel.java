package com.example.test.models;

import java.util.ArrayList;

public class CardModel {

    private String name;
    private Long health;
    private Long damage;
    private ArrayList<CardModel> status;

    final private Long maxHealth = 100L;
    private CardModel cardModelObjetivo;

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

    public Long getDamage() {
        return damage;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
    }

    public ArrayList<CardModel> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<CardModel> status) {
        this.status = status;
    }

    public CardModel getCardModelObjetivo() {
        return cardModelObjetivo;
    }

    public void setCardModelObjetivo(CardModel cardModelObjetivo) {
        this.cardModelObjetivo = cardModelObjetivo;
    }

    public String victory(CardModel c) {
        if (this.health > c.health) {
            return String.format("Soy el ganador de nombre %s", this.name);
        }
        return String.format("Soy el ganador de nombre %s", c.name);
    }

    public void combat(CardModel c) {
        long resta = this.health - c.damage;
        System.out.println(
                String.format(("La carta %s ha hecho %d a la carta %s"), this.name, resta, c.name));
    }
}
