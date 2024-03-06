package dev.patika.VeterinaryManagementSystem.dto.response.appointment;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private long id;
    private LocalDate appointmentDate;
    private int animalId;
    private int customerId;
    private int doctorId;
}
