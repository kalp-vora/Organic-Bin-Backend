package com.organicbin.service;

import com.organicbin.entity.City;
import com.organicbin.entity.State;
import com.organicbin.repository.CityRepository;
import com.organicbin.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaticService {


    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public State addState(State state) {
        return stateRepository.save(state);
    }

    public List<State> getStates(){
        return stateRepository.findAll();
    }

}
