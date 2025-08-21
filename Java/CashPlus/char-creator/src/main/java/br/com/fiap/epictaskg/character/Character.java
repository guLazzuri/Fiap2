package br.com.fiap.epictaskg.character;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{character.name.notblank}")
    @Size(min = 3, max = 40, message = "{character.name.size}")
    private String name;

    @NotBlank(message = "{character.species.notblank}")
    @Pattern(regexp = "HUMAN|CYBORG|ALIEN|ANDROID", message = "{character.species.pattern}")
    private String species;

    @NotNull(message = "{character.startingLevel.notnull}")
    @Min(value = 1, message = "{character.startingLevel.min}")
    @Max(value = 100, message = "{character.startingLevel.max}")
    private Integer startingLevel;

    @NotBlank(message = "{character.specialAbility.notblank}")
    @Size(max = 60, message = "{character.specialAbility.size}")
    private String specialAbility;

    @Size(max = 280, message = "{character.bio.size}")
    private String bio;

    @PastOrPresent(message = "{character.creationDate.pastOrPresent}")
    @NotNull(message = "{character.creationDate.notnull}")
    private LocalDate creationDate;

}


