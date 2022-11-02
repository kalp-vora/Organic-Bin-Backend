package com.organicbin.service;

import com.organicbin.entity.Address;
import com.organicbin.entity.User;
import com.organicbin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Address addAddress(User user) {
        return null;
    }

}
