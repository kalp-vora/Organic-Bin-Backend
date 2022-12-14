package com.organicbin.repository;

import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAppointmentRepository extends JpaRepository<CustomerAppointment, Long> {
    List<CustomerAppointment> findByUserId(User userId);
}
