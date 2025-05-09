package com.lazzuri.CashPlus.model;

public record  Token(
    String token,
    Long expiration,
    String type,
    String role

) {}
