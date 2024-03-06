package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Customer get(int id);
    Page<Customer> cursor(int page,int pageSize,String name);
    boolean delete(int id);
}
