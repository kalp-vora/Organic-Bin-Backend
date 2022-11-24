package com.organicbin.controller;

import com.organicbin.entity.Address;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.organicbin.response.ResponseMessageConstants.userAlreadyExist;

@RestController
@RequestMapping("api/address/")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@Valid @RequestBody Address address) {
        Address newAddress = null;
        newAddress = addressService.addAddress(address);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);

    }

}
