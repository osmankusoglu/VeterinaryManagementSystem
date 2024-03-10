package dev.patika.VeterinaryManagementSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_id",columnDefinition = "serial")
    private long id;

    @NotNull
    @Column(name = "vaccine_name")
    private String name;

    @NotNull
    @Column(name = "vaccine_code")
    private String code;

    @NotNull
    @Column(name = "vaccine_protection_start_date")
    private LocalDate protectionStartDate;

    @NotNull
    @Column(name = "vaccine_protection_finish_date")
    private LocalDate protectionFinishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
