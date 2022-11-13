package com.example.test.services;

import com.example.test.models.UserModel;
import com.example.test.models.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public enum LoginStatus {LOGIN_OK, USER_NOT_FOUND, ERROR_PASSWORD}

    @Resource
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public LoginStatus login(String eMail, String password) {
        Optional<UserModel> usuario = userRepository.findByEmail(eMail);
        if (!usuario.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!usuario.get().getPassword().equals(password)) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }

    @Transactional(readOnly = true)
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Transactional(readOnly = true)
    public UserModel findById(Long usuarioId) {
        return userRepository.findById(usuarioId).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

}
