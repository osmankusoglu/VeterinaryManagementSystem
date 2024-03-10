package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.entities.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    //Proje isterlerine göre hayvan sahibi kaydediliyor (Question 10)
    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer get(int id);

    //Hayvan sahipleri isme göre filtreler (Question 11)
    Page<Customer> cursor(int page, int pageSize, String name);

    boolean delete(int id);
}
