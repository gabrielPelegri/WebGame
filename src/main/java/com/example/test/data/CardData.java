package com.example.test.data;

import com.example.test.models.CardModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;

@Document(collection = "cards")
public class CardData {

    @Id
    ObjectId id;
    private String name;
    private Long health;
    private Long damage;
    private ArrayList<CardModel> status;

    final private int maxHealth = 100;

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

}

