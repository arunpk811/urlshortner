package com.pk.demo.repository;

import com.pk.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {
    List<User> findAll();
}
