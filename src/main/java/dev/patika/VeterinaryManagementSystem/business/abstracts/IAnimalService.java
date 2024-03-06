package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Animal;
import org.springframework.data.domain.Page;

public interface IAnimalService {
    Animal save(Animal animal);
    Animal update(Animal animal);
    Animal get(int id);
    Page<Animal> cursor(int page, int pageSize, String name);
    boolean delete(int id);
}
