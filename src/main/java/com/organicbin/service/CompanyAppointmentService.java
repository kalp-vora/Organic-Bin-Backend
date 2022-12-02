package com.organicbin.service;

import com.organicbin.entity.CompanyAppointment;
import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import com.organicbin.exception.AuthenticationException;
import com.organicbin.repository.CompanyAppointmentRepository;
import com.organicbin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyAppointmentService {

    private final CompanyAppointmentRepository companyAppointmentRepository;
    private final UserRepository userRepository;

    public CompanyAppointmentService(CompanyAppointmentRepository companyAppointmentRepository, UserRepository userRepository) {
        this.companyAppointmentRepository = companyAppointmentRepository;
        this.userRepository = userRepository;
    }

    public CompanyAppointment addCompanyAppointment(CompanyAppointment companyAppointment) {
        return companyAppointmentRepository.save(companyAppointment);
    }

    public List<CompanyAppointment> getCompanyAppointments(Long id) throws AuthenticationException {
        User user = new User();
        user.setId(id);

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new AuthenticationException("USER NOT FOUND");
        }
        List<CompanyAppointment> companyAppointments = companyAppointmentRepository.findByUserId(user);

        return companyAppointments;
    }
}
