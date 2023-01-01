package com.example.test.services;

import com.example.test.data.UserData;
import org.bson.types.ObjectId;
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
    public LoginStatus login(String mail, String password) {
        Optional<UserData> usuario = userRepository.findByMail(mail);
        if (!usuario.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!usuario.get().getPassword().equals(password)) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }

    @Transactional(readOnly = true)
    public UserData findByMail(String mail) {
        return userRepository.findByMail(mail).orElse(null);
    }

    @Transactional(readOnly = true)
    public UserData findById(ObjectId usuarioId) {
        return userRepository.findById(usuarioId).orElse(null);
    }

    @Transactional
    public UserData findByUsername(String username) {
        return userRepository.findByName(username).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<UserData> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserData save(UserData user) {
        return userRepository.save(user);
    }

    @Transactional
    public void remove(UserData user) {
        userRepository.delete(user);
    }
}
