package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Doctor;
import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    Doctor get(int id);
    Page<Doctor> cursor(int page, int pageSize);
    boolean delete(int id);
}
