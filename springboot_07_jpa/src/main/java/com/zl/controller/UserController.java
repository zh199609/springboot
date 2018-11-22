package com.zl.controller;

import com.zl.entity.User;
import com.zl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("user/{id}")
    public User getUser(@PathVariable("id")Integer id){
        return userRepository.getOne(id);
    }
}
