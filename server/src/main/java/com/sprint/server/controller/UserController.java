package com.sprint.server.controller;

import com.sprint.repository.entity.User;
import com.sprint.repository.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public HttpEntity getAllUsers(){
        log.info("[getAllUsers] Returning All the users");
        List<User> users = userRepository.findAll();
        return new HttpEntity(users);
    }

    @GetMapping("/user/{id}")
    public HttpEntity getUserById(@PathVariable Long id){
        log.info("[getAllUsers] Returning All the users");
        Optional<User> user = userRepository.findById(id);
        return new HttpEntity(user);
    }
}
