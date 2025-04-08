package com.lazzuri.CashPlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazzuri.CashPlus.model.Assets;

public interface AssetsRepository extends JpaRepository<Assets, Long> {
    
}
