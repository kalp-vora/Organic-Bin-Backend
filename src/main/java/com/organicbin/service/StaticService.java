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

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    public List<City> getCityOfState(Integer id) {
        State state = new State();
        state.setId(id);
        return cityRepository.findCityByStateId(state);
    }

}
