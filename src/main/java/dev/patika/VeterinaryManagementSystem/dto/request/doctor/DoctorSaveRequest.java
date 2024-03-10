package dev.patika.VeterinaryManagementSystem.dto.request.doctor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSaveRequest {

    @NotNull(message = "Doktor adı boş veya null olamaz")
    private String name;

    @NotNull(message = "Doktor telefonu boş veya null olamaz")
    private String phone;

    @NotNull(message = "Doktor maili boş veya null olamaz")
    @Email
    private String mail;

    @NotNull(message = "Doktor adresi boş veya null olamaz")
    private String address;

    @NotNull(message = "Doktorun yaşadığı şehir boş veya null olamaz")
    private String city;
}
