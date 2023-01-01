package com.example.test.models.statusModels;

import com.example.test.models.CardModel;

public abstract class StatusModel {

    CardModel cardModel;

    public StatusModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

    public CardModel getCardModel() {
        return cardModel;
    }

    public void setCardModel(CardModel cardModel) {
        this.cardModel = cardModel;
    }

}
