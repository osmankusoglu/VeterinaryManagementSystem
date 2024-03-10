package dev.patika.VeterinaryManagementSystem.dto.request.vaccine;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {

    @NotNull(message = "Aşı adı boş veya null olamaz")
    private String name;

    @NotNull(message = "Aşı kodu boş veya null olamaz")
    private String code;

    @NotNull(message = "Aşı geçerlilik başlangıç tarihi boş veya null olamaz")
    private LocalDate protectionStartDate;

    @NotNull(message = "Aşı geçerlilik bitiş tarihi boş veya null olamaz")
    private LocalDate protectionFinishDate;

    private int animalId;
}
