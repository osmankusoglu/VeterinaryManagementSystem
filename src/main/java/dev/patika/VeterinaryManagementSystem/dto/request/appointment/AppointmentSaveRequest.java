package dev.patika.VeterinaryManagementSystem.dto.request.appointment;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {

    @NotNull(message = "Randevu tarihi boş veya null olamaz")
    private LocalDate appointmentDate;

    private int animalId;
    private int customerId;
    private int doctorId;
}
