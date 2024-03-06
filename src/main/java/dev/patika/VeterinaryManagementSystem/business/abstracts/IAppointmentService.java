package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Appointment;
import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;

public interface IAppointmentService {
    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    Appointment get(int id);
    Page<Appointment> cursor(int page, int pageSize);
    boolean delete(int id);
}
