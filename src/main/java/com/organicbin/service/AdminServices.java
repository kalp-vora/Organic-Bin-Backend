package com.organicbin.service;

import com.organicbin.entity.City;
import com.organicbin.entity.CollectionSlot;
import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.State;
import com.organicbin.repository.CityRepository;
import com.organicbin.repository.CollectionSlotRepository;
import com.organicbin.repository.CustomerAppointmentRepository;
import com.organicbin.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final CollectionSlotRepository collectionSlotRepository;
    private final CustomerAppointmentRepository customerAppointmentRepository;

    public AdminServices(StateRepository stateRepository, CityRepository cityRepository, CollectionSlotRepository collectionSlotRepository, CustomerAppointmentRepository customerAppointmentRepository) {
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.collectionSlotRepository = collectionSlotRepository;
        this.customerAppointmentRepository = customerAppointmentRepository;
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

    public List<CustomerAppointment> getAllCustomerAppointments() {
        return customerAppointmentRepository.findAll();
    }
}
