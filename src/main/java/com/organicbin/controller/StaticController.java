package com.organicbin.controller;

import com.organicbin.entity.City;
import com.organicbin.entity.CollectionSlot;
import com.organicbin.entity.State;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.StaticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.organicbin.response.ResponseMessageConstants.success;

@RestController
@RequestMapping("api/")
public class StaticController {

    private final StaticService staticService;

    public StaticController(StaticService staticService) {
        this.staticService = staticService;
    }

    @GetMapping("state/get/all")
    public ResponseEntity<?> getStates() {
        List<State> listOfStates = staticService.getStates();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, listOfStates);
    }

    @GetMapping("city/get/{id}")
    public ResponseEntity<List<City>> getCityOfState(@PathVariable("id") Integer id) {
        List<City> listOfCity = staticService.getCityOfState(id);
        return ResponseEntity.status(HttpStatus.OK).body(listOfCity);
    }

    @GetMapping("city/get/all")
    public ResponseEntity<?> getCities() {
        List<City> listOfCity = staticService.getCities();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, listOfCity);
    }

    @GetMapping("/slot/get/all")
    public ResponseEntity<?> getCollectionSlots() {
        List<CollectionSlot> allCollectionSlots = staticService.getCollectionSlots();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, allCollectionSlots);
    }

}