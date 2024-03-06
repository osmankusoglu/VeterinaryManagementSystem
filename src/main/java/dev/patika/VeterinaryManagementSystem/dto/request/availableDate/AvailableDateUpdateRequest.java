package dev.patika.VeterinaryManagementSystem.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;
    @NotNull(message = "Uygun tarih boş veya null olamaz")
    private LocalDate availableDate;
}
