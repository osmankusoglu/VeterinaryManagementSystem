package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    //Proje isterlerine göre doktor kaydetme (Question 15)
    Doctor save(Doctor doctor);

    Doctor update(Doctor doctor);

    Doctor get(int id);

    Page<Doctor> cursor(int page, int pageSize);

    boolean delete(int id);
}
