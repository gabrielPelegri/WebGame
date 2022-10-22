package com.example.test.models;

public class CharacterModel {

    private String name;
    private Long health;
    private Long damage;
    private String status;
    private Long life;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
        this.life = life;
    }

    public String victory(CharacterModel c){
        if(this.life > c.life){
            return String.format("Soy el ganador de nombre %s",this.name);
        }
        return String.format("Soy el ganador de nombre %s",c.name);
    }
}
