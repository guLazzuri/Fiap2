package com.lazzuri.CashPlus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazzuri.CashPlus.model.User;

public interface UserRepository extends JpaRepository<User , Long>{

    Optional<User> findByEmail(String username);

    
}
