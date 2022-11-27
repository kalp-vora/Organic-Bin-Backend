package com.organicbin.service;

import com.organicbin.entity.City;
import com.organicbin.entity.CollectionSlot;
import com.organicbin.entity.State;
import com.organicbin.repository.CityRepository;
import com.organicbin.repository.CollectionSlotRepository;
import com.organicbin.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaticService {

    private final CityRepository cityRepository;
    private final StateRepository stateRepository;
    private final CollectionSlotRepository collectionSlotRepository;

    public StaticService(CityRepository cityRepository, StateRepository stateRepository, CollectionSlotRepository collectionSlotRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
        this.collectionSlotRepository = collectionSlotRepository;
    }

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    public List<City> getCityOfState(Integer id) {
        State state = new State();
        state.setId(id);
        return cityRepository.findCityByStateId(state);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public List<CollectionSlot> getCollectionSlots() {
        return collectionSlotRepository.findAll();
    }
}
