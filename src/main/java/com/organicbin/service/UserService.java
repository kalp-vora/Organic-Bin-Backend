package com.organicbin.service;

import com.organicbin.entity.Address;
import com.organicbin.entity.User;
import com.organicbin.repository.AddressRepository;
import com.organicbin.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser(User user) throws com.organicbin.exception.UserAlreadyExistException {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new com.organicbin.exception.UserAlreadyExistException("User with email " + user.getEmail() + " already exist");
        }
        // ENCRYPTING PASSWORD BEFORE SAVING
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

}
