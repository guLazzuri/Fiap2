package com.lazzuri.CashPlus.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Credentiais(
    @NotBlank
    @Email
    String email,

    @NotBlank
    @jakarta.validation.constraints.Size(min = 6, max = 20)
    String password
) {}
