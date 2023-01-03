package com.example.test.converters;

import com.example.test.data.UserData;
import com.example.test.models.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserDataToUserModelConverter implements Converter<UserData, UserModel> {

    @Override
    public UserModel convert(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setId(userData.getId());
        userModel.setName(userData.getName());
        userModel.setAge(userData.getAge());
        userModel.setMail(userData.getMail());
        userModel.setPassword(userData.getPassword());
        userModel.setWins(userData.getWins());
        return userModel;
    }
}

