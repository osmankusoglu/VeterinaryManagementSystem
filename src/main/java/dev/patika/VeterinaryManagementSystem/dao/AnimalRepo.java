package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    //Hayvanlar isme göre filtreler (Question 13)
    Page<Animal> findByName(String name, Pageable pageable);

    //Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme (Question 14)
    Page<Animal> getByCustomerId(Long customerId, Pageable pageable);
}
