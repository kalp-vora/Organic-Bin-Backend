package com.organicbin.controller;

import com.organicbin.entity.Address;
import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.exception.UserAlreadyExistException;
import com.organicbin.model.UserProfileResponse;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AddressService;
import com.organicbin.service.CustomerAppointmentService;
import com.organicbin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;

import static com.organicbin.response.ResponseMessageConstants.*;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;
    private final AddressService addressService;

    private final CustomerAppointmentService customerAppointmentService;

    public UserController(UserService userService, AddressService addressService, CustomerAppointmentService customerAppointmentService) {
        this.userService = userService;
        this.addressService = addressService;
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

    @PostMapping("/address/add")
    public ResponseEntity<?> addAddress(@Valid @RequestBody Address address) {
        Address insertedAddress = addressService.addAddress(address);
        return ResponseHandler.generateResponse(successAddressAdded, HttpStatus.CREATED, insertedAddress);
    }


    //TODO: UPDATE USER
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable("id") Long id) {
        Collection<UserProfileResponse> user = userService.getUserProfile(id);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, user);
    }

    //customer appointment controller
    @PostMapping("/customer/appointment/add")
    public ResponseEntity<?> addCustomerAppointment(@Valid @RequestBody CustomerAppointment customerAppointment) {
        CustomerAppointment appointment = customerAppointmentService.addCustomerAppointment(customerAppointment);
        return ResponseHandler.generateResponse(successCustomerAppointment, HttpStatus.CREATED, appointment);
    }
}
