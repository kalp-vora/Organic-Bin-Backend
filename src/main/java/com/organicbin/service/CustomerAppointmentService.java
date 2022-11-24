package com.organicbin.service;

import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.repository.CustomerAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAppointmentService {

    private final CustomerAppointmentRepository customerAppointmentRepository;

    public CustomerAppointmentService(CustomerAppointmentRepository customerAppointmentRepository) {
        this.customerAppointmentRepository = customerAppointmentRepository;
    }

    public CustomerAppointment addCustomerAppointment(CustomerAppointment customerAppointment) {
        return customerAppointmentRepository.save(customerAppointment);
    }
}
