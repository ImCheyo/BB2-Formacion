package com.example.bb2formacion.service;

import com.example.bb2formacion.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByUserCode(Integer userCode);
}
