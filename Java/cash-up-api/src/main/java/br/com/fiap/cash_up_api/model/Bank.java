package br.com.fiap.cash_up_api.model;

import java.time.LocalDate;
import java.util.Random;

public class Bank {
    private Long id;
    private int accountNumber;
    private int agency;
    private String name;
    private Long cpf;
    private LocalDate openAccounDate;
    private Double balance;
    private Boolean isActive;
    private TypeAccount type;

    public Bank(Long id, int accountNumber, int agency, String name, Long cpf, LocalDate openAccounDate , Double balance,
            Boolean isActive, TypeAccount type) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (cpf == null) {
            throw new IllegalArgumentException("CPF cannot be empty");
        }
        if (openAccounDate == null || openAccounDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Open account date cannot be in the past");
        }
        if (balance == null || balance < 0) {
            throw new IllegalArgumentException("Balance cannot be less than 0");
        }

        this.id = Math.abs(new Random().nextLong());
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.name = name;
        this.cpf = cpf;
        this.openAccounDate = openAccounDate;
        this.balance = balance;
        this.isActive = isActive;
        this.type = type;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getAgency() {
        return agency;
    }
    public void setAgency(int agency) {
        this.agency = agency;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF cannot be empty");
        }
        this.cpf = cpf;
    }
    public LocalDate getOpenAccounDate() {
        return openAccounDate;
    }
    public void setOpenAccounDate(LocalDate openAccounDate) {
        if (openAccounDate == null || openAccounDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Open account date cannot be in the past");
        }
        this.openAccounDate = openAccounDate;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        if (balance == null || balance < 0) {
            throw new IllegalArgumentException("Balance cannot be less than 0");
        }
        this.balance = balance;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public TypeAccount getType() {
        return type;
    }
    public void setType(TypeAccount type) {
        this.type = type;
    }
}