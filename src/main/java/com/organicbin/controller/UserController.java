package com.organicbin.controller;

import com.organicbin.entity.User;
import com.organicbin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User insertedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedUser);

    }
}
