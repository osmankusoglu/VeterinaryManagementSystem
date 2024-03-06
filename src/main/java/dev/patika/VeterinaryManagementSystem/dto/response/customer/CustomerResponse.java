package dev.patika.VeterinaryManagementSystem.dto.response.customer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private long id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
