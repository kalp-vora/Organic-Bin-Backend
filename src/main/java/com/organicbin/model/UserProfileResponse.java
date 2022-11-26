package com.organicbin.model;

import java.time.LocalDate;


public interface UserProfileResponse {

    String getName();

    String getEmail();

    String getGender();

    LocalDate getDateOfBirth();

    String getContact();

    String getLocation();

    Integer getPincode();

    String getTag();

    String getCity();

    String getState();

}
