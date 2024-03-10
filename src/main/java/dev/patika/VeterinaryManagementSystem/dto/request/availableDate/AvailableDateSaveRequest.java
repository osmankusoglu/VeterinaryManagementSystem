package dev.patika.VeterinaryManagementSystem.dto.request.availableDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {

    @NotNull(message = "Uygun tarih boş veya null olamaz")
    private LocalDate availableDate;

    private int doctorId;
}
