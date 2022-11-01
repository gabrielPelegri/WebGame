package com.example.test.models;

import java.util.ArrayList;

public class CardModel {

    private String name;
    private Long health;
    private Long damage;
    private ArrayList<CardModel> status;
    private Long life;
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

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
        this.life = life;
    }

    public CardModel getCardModelObjetivo() {
        return cardModelObjetivo;
    }

    public void setCardModelObjetivo(CardModel cardModelObjetivo) {
        this.cardModelObjetivo = cardModelObjetivo;
    }

    public String victory(CardModel c) {
        if (this.life > c.life) {
            return String.format("Soy el ganador de nombre %s", this.name);
        }
        return String.format("Soy el ganador de nombre %s", c.name);
    }

    public void combat(CardModel c) {
        long resta = this.life - c.damage;
        System.out.println(
                String.format(("La carta %s ha hecho %d a la carta %s"), this.name, resta, c.name));
    }
}
