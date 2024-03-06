package dev.patika.VeterinaryManagementSystem.dao;

import dev.patika.VeterinaryManagementSystem.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate,Integer> {
}
