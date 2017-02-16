package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by BiSAl MhRzn on 12/23/2016.
 */
public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{
    List<Appointment> findAll();
    Optional<Appointment> findOneById(Integer id);
    void delete(Appointment d);


    @Query("select p from Appointment p where p.id=(select max(p.id) from Appointment p)")
    Appointment findAppointment();

     @Query(value= "select d from Appointment d where d.id=:id")
     Appointment getOneById(@Param("id") Integer id);

    @Query(value="select appointment.appointmentDate from Appointment appointment where appointment.doctorScheduleByDoctorScheduleId.id=:id")
    List<String> appointmentList(@Param("id") Integer id);


}
