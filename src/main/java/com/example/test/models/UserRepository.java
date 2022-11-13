package com.example.test.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByName(String name);

    List<UserModel> findAll();
}

