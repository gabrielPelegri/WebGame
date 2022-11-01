package com.example.test.models.statusModels;

import com.example.test.models.CardModel;

public class Dañado extends StatusModel{

    public Dañado(CardModel cardModel) {
        super(cardModel);
        cardModel.setLife(cardModel.getLife() - 1);
    }

    @Override
    public CardModel getCardModel() {
        return cardModel;
    }

    @Override
    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
        cardModel.setLife(cardModel.getLife() - 1);
    }
}
