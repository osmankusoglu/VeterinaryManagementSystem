package dev.patika.VeterinaryManagementSystem.business.concretes;

import dev.patika.VeterinaryManagementSystem.business.abstracts.IAppointmentService;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.dao.AppointmentRepo;
import dev.patika.VeterinaryManagementSystem.dao.DoctorRepo;
import dev.patika.VeterinaryManagementSystem.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;


    public AppointmentManager(AppointmentRepo appointmentRepo, DoctorRepo doctorRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
    }

    //Proje isterlerine göre randevu kaydediliyor (Question 17 )
    @Override
    public Appointment save(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        this.get((int) appointment.getId());
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment get(int id) {
        return this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Appointment> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Appointment appointment = this.get(id);
        this.appointmentRepo.delete(appointment);
        return true;
    }

    //Randevular kullanıcı tarafından girilen tarih aralığına ve hayvana göre filtrelenir (Question 19)
    @Override
    public Page<Appointment> getAppointmentsByDateAndAnimalId(LocalDateTime startDate, LocalDateTime endDate, Long animalId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findByAppointmentDateBetweenAndAnimalId(startDate, endDate, animalId, pageable);
    }

    //Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtrelenir (Question 20)
    @Override
    public Page<Appointment> getAppointmentsByDateAndDoctorId(LocalDateTime startDate, LocalDateTime endDate, Long doctorId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findByAppointmentDateBetweenAndDoctorId(startDate, endDate, doctorId, pageable);
    }
}
/*Optional<Appointment> appointmentOptional = appointmentRepo.findByAppointmentDateAndDoctorId(appointment.getAppointmentDate(),doctor.getId());
        if () {*/