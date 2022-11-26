package com.organicbin.controller;

import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.exception.UserAlreadyExistException;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.CustomerAppointmentService;
import com.organicbin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.organicbin.response.ResponseMessageConstants.*;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;

    private final CustomerAppointmentService customerAppointmentService;

    public UserController(UserService userService, CustomerAppointmentService customerAppointmentService) {
        this.userService = userService;
        this.customerAppointmentService = customerAppointmentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        User insertedUser;
        try {
            insertedUser = userService.addUser(user);
        } catch (UserAlreadyExistException e) {
            return ResponseHandler.generateResponse(userAlreadyExist, HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse(successUserAdded, HttpStatus.CREATED, insertedUser);
    }

    //customer appointment controller
    @PostMapping("/customer/appointment/add")
    public ResponseEntity<?> addCustomerAppointment(@Valid @RequestBody CustomerAppointment customerAppointment) {
        CustomerAppointment appointment = customerAppointmentService.addCustomerAppointment(customerAppointment);
        return ResponseHandler.generateResponse(successCustomerAppointment, HttpStatus.CREATED, appointment);
    }
}
