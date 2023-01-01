package com.example.test.models.statusModels;

import com.example.test.models.CardModel;

public class Debilitado extends StatusModel {

    CardModel cardModel;

    public Debilitado(CardModel cardModel) {
        super(cardModel);
        cardModel.setDamage(cardModel.getDamage() - 1);
    }

    @Override
    public CardModel getCardModel() {
        return cardModel;
    }

    @Override
    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
        cardModel.setDamage(cardModel.getDamage() - 1);
    }
}
