package com.example.test.services;

import com.example.test.converters.CardDataToCardModelConverter;
import com.example.test.models.CardModel;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Resource
    private CardRepository cardRepository;

    @Resource
    private CardDataToCardModelConverter cardDataToCardModelConverter;

    @Transactional
    public CardModel findById(ObjectId objectId) {
        return cardDataToCardModelConverter.convert(cardRepository.findById(objectId).get());
    }

    @Transactional
    public List<CardModel> findAll() {
        return cardRepository.findAll().stream().map(cardDataToCardModelConverter::convert).collect(Collectors.toList());
    }
}