package com.organicbin.service;

import com.organicbin.entity.CustomerAppointment;
import com.organicbin.exception.AuthenticationException;
import com.organicbin.repository.CustomerAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<List<CustomerAppointment>> getAppointments(Long id) throws AuthenticationException {
        Optional<List<CustomerAppointment>> customerAppointmentList = customerAppointmentRepository.findByUserId(id);
        if (customerAppointmentList.isEmpty()) {
            throw new AuthenticationException("NO USER FOUND");
        }
        return customerAppointmentList;
    }
}
