package com.organicbin.controller;

import com.organicbin.entity.Address;
import com.organicbin.entity.CompanyAppointment;
import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.exception.AuthenticationException;
import com.organicbin.exception.UserAlreadyExistException;
import com.organicbin.model.UserProfileResponse;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AddressService;
import com.organicbin.service.CompanyAppointmentService;
import com.organicbin.service.CustomerAppointmentService;
import com.organicbin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;
import java.util.List;

import static com.organicbin.response.ResponseMessageConstants.*;

@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;
    private final AddressService addressService;

    private final CustomerAppointmentService customerAppointmentService;
    private final CompanyAppointmentService companyAppointmentService;

    public UserController(UserService userService, AddressService addressService, CustomerAppointmentService customerAppointmentService, CompanyAppointmentService companyAppointmentService) {
        this.userService = userService;
        this.addressService = addressService;
        this.customerAppointmentService = customerAppointmentService;
        this.companyAppointmentService = companyAppointmentService;
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

    @PutMapping("/address/update")
    public ResponseEntity<?> updateUserAddress(@RequestBody Address address) {
        Address updatedAddress = addressService.updateUserAddress(address);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, updatedAddress);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable("id") Long id) {
        Collection<UserProfileResponse> user = userService.getUserProfile(id);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, user);
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, updatedUser);
    }

    // Customer APIS
    @PostMapping("/customer/appointment/add")
    public ResponseEntity<?> addCustomerAppointment(@Valid @RequestBody CustomerAppointment customerAppointment) {
        CustomerAppointment appointment = customerAppointmentService.addCustomerAppointment(customerAppointment);
        return ResponseHandler.generateResponse(successCustomerAppointment, HttpStatus.CREATED, appointment);
    }


    @GetMapping("/customer/appointment/get/{id}")
    public ResponseEntity<?> getCustomerAppointments(@PathVariable("id") Long id) {
        List<CustomerAppointment> customerAppointmentList;
        try {
            customerAppointmentList = customerAppointmentService.getCustomerAppointments(id);
        } catch (AuthenticationException e) {
            return ResponseHandler.generateResponse(userNotFound, HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse(success, HttpStatus.OK, customerAppointmentList);
    }

    // COMPANY APIS
    @PostMapping("/company/appointment/add")
    public ResponseEntity<?> addCompanyAppointment(@Valid @RequestBody CompanyAppointment companyAppointment) {
        CompanyAppointment appointment = companyAppointmentService.addCompanyAppointment(companyAppointment);
        return ResponseHandler.generateResponse(successCompanyAppointment, HttpStatus.CREATED, appointment);
    }

    @GetMapping("/company/appointment/get/{id}")
    public ResponseEntity<?> getCompanyAppointments(@PathVariable("id") Long id) {
        List<CompanyAppointment> companyAppointmentList;
        try {
            companyAppointmentList = companyAppointmentService.getCompanyAppointments(id);
        } catch (AuthenticationException e) {
            return ResponseHandler.generateResponse(userNotFound, HttpStatus.OK, null);
        }
        return ResponseHandler.generateResponse(success, HttpStatus.OK, companyAppointmentList);
    }

}
