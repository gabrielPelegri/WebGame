package com.example.test.converters;

import com.example.test.data.CardData;
import com.example.test.models.CardModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class CardDataToCardModelConverter implements Converter<CardData, CardModel> {

    @Override
    public CardModel convert(CardData cardData) {
        CardModel cardModel = new CardModel();
        cardModel.setName(cardData.getName());
        cardModel.setHealth(cardData.getHealth());
        cardModel.setDamage(cardData.getDamage());
        return cardModel;
    }

}
