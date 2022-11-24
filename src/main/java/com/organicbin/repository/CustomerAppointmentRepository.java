package com.organicbin.repository;

import com.organicbin.entity.CustomerAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAppointmentRepository extends JpaRepository<CustomerAppointment, Long> {

}
