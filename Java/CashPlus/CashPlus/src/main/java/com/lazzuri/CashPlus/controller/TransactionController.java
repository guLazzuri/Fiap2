package com.lazzuri.CashPlus.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazzuri.CashPlus.model.Transaction;
import com.lazzuri.CashPlus.repository.TransactionRepository;
import com.lazzuri.CashPlus.specification.TransactionSpecification;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {

    public record TransactionFilter(String description,LocalDate startDate, LocalDate endDate, BigDecimal amount){}

    @Autowired
    private TransactionRepository repository;

    @GetMapping
    public Page<Transaction> index(TransactionFilter filter, @PageableDefault(size = 10, sort= "date", direction= Direction.DESC) Pageable pegeable){
        var specification = TransactionSpecification.withFilter(filter);
        return repository.findAll(specification, pegeable);
    }

}