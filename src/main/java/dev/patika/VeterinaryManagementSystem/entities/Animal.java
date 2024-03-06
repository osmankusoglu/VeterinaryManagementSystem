package dev.patika.VeterinaryManagementSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id",columnDefinition = "serial")
    private long id;

    @NotNull
    @Column(name = "animal_name")
    private String name;

    @NotNull
    @Column(name = "animal_species")
    private String species;

    @NotNull
    @Column(name = "animal_breed")
    private String breed;

    @NotNull
    @Column(name = "animal_gender")
    private String gender;

    @NotNull
    @Column(name = "animal_color")
    private String color;

    @NotNull
    @Column(name = "animal_date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Vaccine> vaccines;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;
}
