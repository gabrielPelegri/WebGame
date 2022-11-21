package com.example.test.models;

import com.example.test.data.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {
    Optional<UserData> findByMail(String mail);

    Optional<UserData> findByName(String name);

    List<UserData> findAll();

}

