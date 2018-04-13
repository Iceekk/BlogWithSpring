package com.example.demo.service;

import com.example.demo.bindingModel.UserBindingModel;

import java.io.IOException;

public interface UserService {
    void create(UserBindingModel userBindingModel) throws IOException;
}
