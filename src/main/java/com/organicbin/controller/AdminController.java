package com.organicbin.controller;

import com.organicbin.entity.City;
import com.organicbin.entity.CollectionSlot;
import com.organicbin.entity.State;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AdminServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.organicbin.response.ResponseMessageConstants.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    private final AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @PostMapping("/state/add")
    public ResponseEntity<?> addState(@RequestBody State state) {
        State insertedState = adminServices.addState(state);
        return ResponseHandler.generateResponse(successStateAdded, HttpStatus.CREATED, insertedState);
    }

    @PostMapping("/city/add")
    public ResponseEntity<?> addCity(@RequestBody City city) {
        City insertedCity = adminServices.addCity(city);
        return ResponseHandler.generateResponse(successCityAdded, HttpStatus.CREATED, insertedCity);
    }

    @PostMapping("/slot/add")
    public ResponseEntity<?> addCollectionSlot(@RequestBody CollectionSlot collectionSlot) {
        CollectionSlot insertedCollectionSlot = adminServices.addCollectionSlot(collectionSlot);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, insertedCollectionSlot);
    }



}
