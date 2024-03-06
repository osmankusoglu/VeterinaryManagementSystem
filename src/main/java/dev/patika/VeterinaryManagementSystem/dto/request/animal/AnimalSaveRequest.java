package dev.patika.VeterinaryManagementSystem.dto.request.animal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {

    @NotNull(message = "Hayvan adı boş veya null olamaz")
    private String name;

    @NotNull(message = "Hayvan türü boş veya null olamaz")
    private String species;

    @NotNull(message = "Hayvan cinsi boş veya null olamaz")
    private String breed;

    @NotNull(message = "Hayvan cinsiyeti boş veya null olamaz")
    private String gender;

    @NotNull(message = "Hayvan rengi boş veya null olamaz")
    private String color;

    @NotNull(message = "Hayvanın doğum tarihi boş veya null olamaz")
    private LocalDate dateOfBirth;

    private int customerId;
}
