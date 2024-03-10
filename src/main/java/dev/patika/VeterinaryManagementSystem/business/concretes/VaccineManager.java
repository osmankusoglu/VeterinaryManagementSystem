package dev.patika.VeterinaryManagementSystem.business.concretes;

import dev.patika.VeterinaryManagementSystem.business.abstracts.IVaccineService;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.dao.VaccineRepo;
import dev.patika.VeterinaryManagementSystem.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    //Proje isterlerine göre hayvana ait aşı kaydediliyor (Question 21)
    @Override
    public Vaccine save(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get((int) vaccine.getId());
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine get(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        Vaccine vaccine = this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    //Belirli bir hayvana ait tüm aşı kayıtları (sadece bir hayvanın tüm aşı kayıtları) listeler (Question 24)
    @Override
    public Page<Vaccine> getByAllAnimalId(int page, int pageSize, Long animalId) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.getByAnimalId(animalId, pageable);
    }

    //Hayvanların aşı kayıtları, girilen tarih aralığına göre doğru şekilde listelenir. (Question 23)
    @Override
    public Page<Vaccine> cursorByDateRange(int page, int pageSize, LocalDate startDate, LocalDate endDate) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findByProtectionStartDateBetween(startDate, endDate, pageable);
    }
}
