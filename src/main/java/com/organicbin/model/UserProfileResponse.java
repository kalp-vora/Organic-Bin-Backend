package com.organicbin.model;

import java.time.LocalDate;


public interface UserProfileResponse {

    String getName();

    String getEmail();

    String getGender();

    LocalDate getDate_of_birth();

    String getContact();

    String getLocation();

    Integer getPincode();

    String getTag();

    Long getAddress_id();

    String getCity();

    String getState();

}
