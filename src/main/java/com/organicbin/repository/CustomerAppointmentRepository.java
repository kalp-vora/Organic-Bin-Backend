package com.organicbin.repository;

import com.organicbin.entity.CustomerAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerAppointmentRepository extends JpaRepository<CustomerAppointment, Long> {
    Optional<List<CustomerAppointment>> findByUserId(Long id);
}
