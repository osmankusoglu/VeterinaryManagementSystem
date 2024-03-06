package dev.patika.VeterinaryManagementSystem.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;

    @NotNull(message = "Müşteri adı boş veya null olamaz")
    private String name;

    @NotNull(message = "Müşteri telefonu boş veya null olamaz")
    private String phone;

    @NotNull(message = "Müşteri maili boş veya null olamaz")
    @Email
    private String mail;

    @NotNull(message = "Müşteri adresi boş veya null olamaz")
    private String address;

    @NotNull(message = "Müşteri yaşadığı şehir boş veya null olamaz")
    private String city;


}
