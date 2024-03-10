package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.dto.response.animal.AnimalResponse;
import dev.patika.VeterinaryManagementSystem.entities.Animal;
import org.springframework.data.domain.Page;

public interface IAnimalService {
    //Proje isterlerine göre hayvan kaydediliyor (Question 12)
    AnimalResponse save(Animal animal);

    Animal update(Animal animal);

    Animal get(int id);

    //Hayvanlar isme göre filtreler (Question 13)
    Page<Animal> cursor(int page, int pageSize, String name);

    boolean delete(int id);

    //Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme (Question 14)
    Page<Animal> getByAllCustomerId(int page, int pageSize, Long customerId);

}
