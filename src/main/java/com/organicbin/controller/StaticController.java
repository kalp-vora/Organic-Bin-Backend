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
@RequestMapping("api/v1/static/")
public class StaticController {

    @Autowired
    StaticService staticService;

    @PostMapping("city/register")
    public ResponseEntity<City> registerCity(@RequestBody City city) {
        City insertedCity = staticService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedCity);
    }

    @PostMapping("state/register")
    public ResponseEntity<State> registerState(@RequestBody State state) {
        State insertedState = staticService.addState(state);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedState);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("state/get/all")
    public ResponseEntity<List<State>> getStates(){
        List<State> listOfStates = staticService.getStates();
        return ResponseEntity.status(HttpStatus.OK).body(listOfStates);
    }
}
