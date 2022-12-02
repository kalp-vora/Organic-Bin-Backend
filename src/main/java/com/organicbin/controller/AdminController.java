package com.organicbin.controller;

import com.organicbin.entity.*;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AdminServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.organicbin.response.ResponseMessageConstants.*;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    private final AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @PostMapping("/state/add")
    public ResponseEntity<?> addState(@RequestBody State state) {
        State insertedState = adminServices.addState(state);
        return ResponseHandler.generateResponse(successStateAdded, HttpStatus.CREATED, insertedState);
    }

    @PostMapping("/city/add")
    public ResponseEntity<?> addCity(@RequestBody City city) {
        City insertedCity = adminServices.addCity(city);
        return ResponseHandler.generateResponse(successCityAdded, HttpStatus.CREATED, insertedCity);
    }

    @PostMapping("/slot/add")
    public ResponseEntity<?> addCollectionSlot(@RequestBody CollectionSlot collectionSlot) {
        CollectionSlot insertedCollectionSlot = adminServices.addCollectionSlot(collectionSlot);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, insertedCollectionSlot);
    }

    @GetMapping("/customer/appointment/get/all")
    public ResponseEntity<?> getAllCustomerAppointments() {
        List<CustomerAppointment> customerAppointments = adminServices.getAllCustomerAppointments();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, customerAppointments);
    }

    @GetMapping("/company/appointment/get/all")
    public ResponseEntity<?> getAllCompanyAppointments() {
        List<CompanyAppointment> companyAppointments = adminServices.getAllCompanyAppointments();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, companyAppointments);
    }

    @PutMapping("/customer/appointment/changeStatus")
    public ResponseEntity<?> changeCustomerAppointmentStatus(@RequestBody CustomerAppointment customerAppointment) {
        CustomerAppointment updatedCustomerAppointment = adminServices.updateCustomerAppointmentStatus(customerAppointment);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, updatedCustomerAppointment);
    }

    @PutMapping("/company/appointment/changeStatus")
    public ResponseEntity<?> changeCompanyAppointmentStatus(@RequestBody CompanyAppointment companyAppointment) {
        CompanyAppointment updatedCompanyAppointment = adminServices.updateCompanyAppointmentStatus(companyAppointment);
        return ResponseHandler.generateResponse(success, HttpStatus.OK, updatedCompanyAppointment);
    }

    @GetMapping("/user/get/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = adminServices.getAllUsers();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, userList);
    }

    @GetMapping("/collector/get/all")
    public ResponseEntity<?> getAllCollectors() {
        List<User> collectorList = adminServices.getAllCollectors();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, collectorList);
    }

    @GetMapping("/company/get/all")
    public ResponseEntity<?> getAllCompany() {
        List<User> companyList = adminServices.getAllCompany();
        return ResponseHandler.generateResponse(success, HttpStatus.OK, companyList);
    }

}
