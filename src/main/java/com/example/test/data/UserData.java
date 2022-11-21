package com.example.test.data;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document("users")
public class UserData {
    @Id
    private Long id;
    private String name;
    private String password;
    private String mail;
    private Integer age;
    private Integer wins;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getWins() {
        return wins;
    }
    public void setWins(Integer wins) {
        this.wins = wins;
    }
    public UserData() {
    }

}
