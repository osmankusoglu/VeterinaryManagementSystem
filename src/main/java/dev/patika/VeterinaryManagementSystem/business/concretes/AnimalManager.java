package dev.patika.VeterinaryManagementSystem.business.concretes;

import dev.patika.VeterinaryManagementSystem.business.abstracts.IAnimalService;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.dao.AnimalRepo;
import dev.patika.VeterinaryManagementSystem.dto.response.animal.AnimalResponse;
import dev.patika.VeterinaryManagementSystem.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    //Proje isterlerine göre hayvan kaydediliyor (Question 12)
    @Override
    public AnimalResponse save(Animal animal) {
        Animal savedAnimal = this.animalRepo.save(animal);
        AnimalResponse animalResponse = new AnimalResponse((int) savedAnimal.getId(), savedAnimal.getName(), savedAnimal.getSpecies(), savedAnimal.getBreed(),
                savedAnimal.getGender(), savedAnimal.getColor(), savedAnimal.getDateOfBirth(),
                (int) savedAnimal.getCustomer().getId());
        return animalResponse;
    }

    @Override
    public Animal update(Animal animal) {
        this.get((int) animal.getId());
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal get(int id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    //Hayvanlar isme göre filtreler (Question 13)
    @Override
    public Page<Animal> cursor(int page, int pageSize, String name) {
        Pageable pageable = PageRequest.of(page, pageSize);
        if (name.isEmpty()) {
            return this.animalRepo.findAll(pageable);
        } else {
            return this.animalRepo.findByName(name, pageable);
        }
    }

    @Override
    public boolean delete(int id) {
        Animal animal = this.get(id);
        this.animalRepo.delete(animal);
        return true;
    }

    //Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme (Question 14)
    @Override
    public Page<Animal> getByAllCustomerId(int page, int pageSize, Long customerId) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.getByCustomerId(customerId, pageable);
    }
}
