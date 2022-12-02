package com.organicbin.repository;

import com.organicbin.entity.CompanyAppointment;
import com.organicbin.entity.CustomerAppointment;
import com.organicbin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAppointmentRepository extends JpaRepository<CompanyAppointment, Long> {
    List<CompanyAppointment> findByUserId(User userId);
}
