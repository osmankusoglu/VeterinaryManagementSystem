package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.AvailableDate;
import org.springframework.data.domain.Page;

public interface IAvailableDateService {
    //Proje isterlerine göre doktor müsait günü kaydediliyor (Question 16)
    AvailableDate save(AvailableDate availableDate);

    AvailableDate update(AvailableDate availableDate);

    AvailableDate get(int id);

    Page<AvailableDate> cursor(int page, int pageSize);

    boolean delete(int id);
}
