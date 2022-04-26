package com.pk.demo.service;

import com.pk.demo.model.User;
import com.pk.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        user.setCreatedDate(LocalDate.now());
        return userRepository.save(user);
    }
}
