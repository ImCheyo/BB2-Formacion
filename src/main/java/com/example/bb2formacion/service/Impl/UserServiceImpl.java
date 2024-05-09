package com.example.bb2formacion.service.Impl;

import com.example.bb2formacion.model.User;
import com.example.bb2formacion.repository.UserRepository;
import com.example.bb2formacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByUserCode(Integer userCode) {
        return userRepository.getUserByUserCode(userCode);
    }
}
