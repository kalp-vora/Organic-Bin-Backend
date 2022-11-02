package com.organicbin.repository;

import com.organicbin.entity.City;
import com.organicbin.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findCityByStateId(State state);
}
