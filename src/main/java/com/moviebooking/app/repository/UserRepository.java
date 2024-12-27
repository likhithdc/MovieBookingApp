package com.moviebooking.app.repository;

import com.moviebooking.app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("INSERT INTO User (name, email, password) VALUES (:name, :email, :password)")
    void saveUser(@Param("name") String name,
                  @Param("email") String email,
                  @Param("password") String password);

}