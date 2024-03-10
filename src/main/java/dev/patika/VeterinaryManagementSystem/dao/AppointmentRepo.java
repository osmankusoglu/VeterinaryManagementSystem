package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    //Randevular kullanıcı tarafından girilen tarih aralığına ve hayvana göre filtrelenir (Question 19)
    Page<Appointment> findByAppointmentDateBetweenAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId, Pageable pageable);

    //Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtrelenir (Question 20)
    Page<Appointment> findByAppointmentDateBetweenAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId, Pageable pageable);
}
