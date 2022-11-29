package com.organicbin.service;

import com.organicbin.entity.*;
import com.organicbin.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final CollectionSlotRepository collectionSlotRepository;
    private final CustomerAppointmentRepository customerAppointmentRepository;
    private final UserRepository userRepository;

    public AdminServices(StateRepository stateRepository, CityRepository cityRepository, CollectionSlotRepository collectionSlotRepository, CustomerAppointmentRepository customerAppointmentRepository, UserRepository userRepository) {
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.collectionSlotRepository = collectionSlotRepository;
        this.customerAppointmentRepository = customerAppointmentRepository;
        this.userRepository = userRepository;
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

    public CustomerAppointment updateCustomerAppointmentStatus(CustomerAppointment customerAppointment)
    {
        return customerAppointmentRepository.save(customerAppointment);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
