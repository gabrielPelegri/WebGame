package com.example.test.models.statusModels;

import com.example.test.models.CardModel;

public class Muerto extends StatusModel{

    public Muerto(CardModel cardModel) {
        super(cardModel);
        cardModel.setHealth(0L);
    }

    @Override
    public CardModel getCardModel() {
        return cardModel;
    }

    @Override
    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
        cardModel.setHealth(0L);
    }
}
