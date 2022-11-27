package com.organicbin.service;

import com.organicbin.entity.City;
import com.organicbin.entity.CollectionSlot;
import com.organicbin.entity.State;
import com.organicbin.repository.CityRepository;
import com.organicbin.repository.CollectionSlotRepository;
import com.organicbin.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final CollectionSlotRepository collectionSlotRepository;

    public AdminServices(StateRepository stateRepository, CityRepository cityRepository, CollectionSlotRepository collectionSlotRepository) {
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.collectionSlotRepository = collectionSlotRepository;
    }

    public State addState(State state) {
        return stateRepository.save(state);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public CollectionSlot addCollectionSlot(CollectionSlot collectionSlot) {
        return collectionSlotRepository.save(collectionSlot);
    }
}
