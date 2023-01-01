package com.example.test.models.statusModels;

import com.example.test.models.CardModel;

public class Curado extends StatusModel{

    public Curado(CardModel cardModel) {
        super(cardModel);
        cardModel.setHealth(cardModel.getHealth() + 1);
    }

    @Override
    public CardModel getCardModel() {
        return cardModel;
    }

    @Override
    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
        cardModel.setHealth(cardModel.getHealth() + 1);
    }
}
