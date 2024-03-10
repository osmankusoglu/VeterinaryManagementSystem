package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Appointment;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface IAppointmentService {

    //Proje isterlerine göre randevu kaydediliyor (Question 17 )
    Appointment save(Appointment appointment);

    Appointment update(Appointment appointment);

    Appointment get(int id);

    Page<Appointment> cursor(int page, int pageSize);

    boolean delete(int id);

    //Randevular kullanıcı tarafından girilen tarih aralığına ve hayvana göre filtrelenir (Question 19)
    Page<Appointment> getAppointmentsByDateAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId, int page, int pageSize);

    //Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtrelenir (Question 20)
    Page<Appointment> getAppointmentsByDateAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId, int page, int pageSize);
}
