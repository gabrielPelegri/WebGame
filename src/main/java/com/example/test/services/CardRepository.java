package com.example.test.services;

import com.example.test.data.CardData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends MongoRepository<CardData, ObjectId> {

    List<CardData> findAll();

    Optional<CardData> findById(ObjectId objectId);
}

