package com.example.test.services;

import com.example.test.data.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserData, Long> {
    Optional<UserData> findByMail(String mail);

    Optional<UserData> findByName(String name);

    List<UserData> findAll();

}

