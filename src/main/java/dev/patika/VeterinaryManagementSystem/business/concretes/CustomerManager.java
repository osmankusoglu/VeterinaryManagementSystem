package dev.patika.VeterinaryManagementSystem.business.concretes;

import dev.patika.VeterinaryManagementSystem.business.abstracts.ICustomerService;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.dao.CustomerRepo;
import dev.patika.VeterinaryManagementSystem.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    //Proje isterlerine göre hayvan sahibi kaydediliyor (Question 10)
    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }


    @Override
    public Customer get(int id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    //Hayvan sahipleri isme göre filtreler (Question 11)
    @Override
    public Page<Customer> cursor(int page, int pageSize, String name) {
        Pageable pageable = PageRequest.of(page, pageSize);
        if (name.isEmpty()) {
            return this.customerRepo.findAll(pageable);
        } else {
            return this.customerRepo.findByName(name, pageable);
        }
    }

    @Override
    public boolean delete(int id) {
        Customer customer = this.get(id);
        this.customerRepo.delete(customer);
        return true;
    }

    @Override
    public Customer update(Customer customer) {
        this.get((int) customer.getId());
        return this.customerRepo.save(customer);
    }
}
