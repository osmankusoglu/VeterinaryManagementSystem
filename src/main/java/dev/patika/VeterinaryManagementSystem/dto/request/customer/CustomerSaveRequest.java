package dev.patika.VeterinaryManagementSystem.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    @NotNull(message = "Müşteri adı boş veya null olamaz")
    private String name;

    @NotNull(message = "Müşteri telefonu boş veya null olamaz")
    private String phone;

    @NotNull(message = "Müşteri maili boş veya null olamaz")
    @Email
    private String mail;

    @NotNull(message = "Müşteri adresi boş veya null olamaz")
    private String address;

    @NotNull(message = "Müşterinin yaşadığı şehir boş veya null olamaz")
    private String city;
}
