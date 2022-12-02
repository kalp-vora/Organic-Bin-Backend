package com.organicbin.repository;

import com.organicbin.entity.User;
import com.organicbin.model.UserProfileResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT users.name, users.email, users.gender, users.date_of_birth, users.contact," +
            "address.location, address.pincode, address.tag, address.id as address_id, city.name as city, state.name as state FROM users " +
            "JOIN address ON users.id = address.user_id " +
            "JOIN city ON address.city_id = city.id " +
            "JOIN state ON city.state_id = state.id WHERE users.id = ?1", nativeQuery = true)
    Collection<UserProfileResponse> getUserProfile(Long id);

    List<User> findByRole(String role);
}