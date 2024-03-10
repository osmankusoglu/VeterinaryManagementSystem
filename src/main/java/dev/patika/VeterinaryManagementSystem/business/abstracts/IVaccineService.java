package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface IVaccineService {
    //Proje isterlerine göre hayvana ait aşı kaydediliyor (Question 21)
    Vaccine save(Vaccine vaccine);

    Vaccine update(Vaccine vaccine);

    Vaccine get(int id);

    boolean delete(int id);

    Page<Vaccine> cursor(int page, int pageSize);

    //Hayvanların aşı kayıtları, girilen tarih aralığına göre doğru şekilde listelenir. (Question 23)
    Page<Vaccine> cursorByDateRange(int page, int pageSize, LocalDate startDate, LocalDate endDate);

    //Belirli bir hayvana ait tüm aşı kayıtları (sadece bir hayvanın tüm aşı kayıtları) listeler (Question 24)
    Page<Vaccine> getByAllAnimalId(int page, int pageSize, Long animalId);
}
