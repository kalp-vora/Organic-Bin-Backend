package com.organicbin.controller;

import com.organicbin.entity.City;
import com.organicbin.entity.State;
import com.organicbin.service.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class StaticController {

    @Autowired
    StaticService staticService;

    @GetMapping("state/get/all")
    public ResponseEntity<List<State>> getStates() {
        List<State> listOfStates = staticService.getStates();
        return ResponseEntity.status(HttpStatus.OK).body(listOfStates);
    }

    @GetMapping("city/get/{id}")
    public ResponseEntity<List<City>> getCityOfState(@PathVariable("id") Integer id) {
        List<City> listOfCity = staticService.getCityOfState(id);
        return ResponseEntity.status(HttpStatus.OK).body(listOfCity);
    }
}