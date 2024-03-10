package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {
    //Belirli bir hayvana ait tüm aşı kayıtları (sadece bir hayvanın tüm aşı kayıtları) listeler (Question 24)
    Page<Vaccine> getByAnimalId(Long animalId, Pageable pageable);

    //Hayvanların aşı kayıtları, girilen tarih aralığına göre doğru şekilde listelenir. (Question 23)
    Page<Vaccine> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

}
