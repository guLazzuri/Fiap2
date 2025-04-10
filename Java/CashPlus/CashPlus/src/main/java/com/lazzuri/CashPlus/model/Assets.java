package com.lazzuri.CashPlus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo obrigatório")
    private String name;

    @Positive(message = "O preço deve ser positivo")
    private double price;

    @NotBlank(message = "campo obrigatório")
    @Pattern(regexp = "^[A-Za-z].*", message = "deve começar com uma letra")
    private String icon;

    @NotNull(message = "campo obrigatório")
    @Positive(message = "A quantidade deve ser positiva")
    private Integer quantity;
}
