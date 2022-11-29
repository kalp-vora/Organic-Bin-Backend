package com.organicbin.service;

import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.exception.AuthenticationException;
import com.organicbin.repository.CustomerAppointmentRepository;
import com.organicbin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAppointmentService {

    private final CustomerAppointmentRepository customerAppointmentRepository;

    private final UserRepository userRepository;

    public CustomerAppointmentService(CustomerAppointmentRepository customerAppointmentRepository, UserRepository userRepository) {
        this.customerAppointmentRepository = customerAppointmentRepository;
        this.userRepository = userRepository;
    }

    public CustomerAppointment addCustomerAppointment(CustomerAppointment customerAppointment) {
        return customerAppointmentRepository.save(customerAppointment);
    }

    public List<CustomerAppointment> getCustomerAppointments(Long id) throws AuthenticationException {
        User user = new User();
        user.setId(id);

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new AuthenticationException("USER NOT FOUND");
        }
        List<CustomerAppointment> customerAppointments = customerAppointmentRepository.findByUserId(user);

        return customerAppointments;
    }
}
