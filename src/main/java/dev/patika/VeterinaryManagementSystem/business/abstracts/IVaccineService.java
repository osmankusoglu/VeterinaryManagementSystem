package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Animal;
import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;

public interface IVaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine update(Vaccine vaccine);
    Vaccine get(int id);
    Page<Vaccine> cursor(int page, int pageSize);
    boolean delete(int id);
}
