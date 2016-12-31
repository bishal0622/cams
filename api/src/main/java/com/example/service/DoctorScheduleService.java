package com.example.service;

import com.example.domain.Appointment;
import com.example.domain.Doctor;
import com.example.domain.DoctorSchedule;
import com.example.repository.DoctorScheduleRepository;
import com.example.service.dto.DoctorScheduleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by japnica on 12/25/2016.
 */
@Service
@Transactional
public class DoctorScheduleService {
    @Inject
    DoctorScheduleRepository doctorScheduleRepository;

    private final Logger log = LoggerFactory.getLogger(DoctorScheduleService.class);

    public DoctorSchedule saveSchedule(DoctorScheduleDTO doctorScheduleDTO){
        DoctorSchedule doctorSchedule=new DoctorSchedule();
        doctorSchedule.setDoctorId(doctorScheduleDTO.getDoctorId());
        doctorSchedule.setDoctorScheduleTo(doctorScheduleDTO.getDoctorScheduleTo());
        doctorSchedule.setDoctorScheduleFrom(doctorScheduleDTO.getDoctorScheduleFrom());
        doctorSchedule.setDayOfWeek(doctorScheduleDTO.getDayOfWeek());
        doctorSchedule.setAppointmentsByDoctorScheduleId(doctorScheduleDTO.getAppointmentsByDoctorScheduleId());
        doctorSchedule.setDoctorByDoctorId(doctorScheduleDTO.getDoctorByDoctorId());
        doctorScheduleRepository.save(doctorSchedule);
        log.debug("Created Information for doctor schedule: {}", doctorSchedule);
        return doctorSchedule;
    }

    public List<DoctorSchedule> getAllSchedule(){
        List<DoctorSchedule> doctorSchedules=doctorScheduleRepository.findAll();
        return doctorSchedules;
    }

    public void updateSchedule(Integer doctorScheduleId, Integer doctorId, Timestamp doctorScheduleTo, Timestamp doctorScheduleFrom, Integer dayOfWeek, Collection<Appointment> appointmentsByDoctorScheduleId, Doctor doctorByDoctorId){
        doctorScheduleRepository.findOneById(doctorScheduleId).ifPresent(doctorSchedule->{
            doctorSchedule.setDoctorId(doctorId);
            doctorSchedule.setDoctorScheduleTo(doctorScheduleTo);
            doctorSchedule.setDoctorScheduleFrom(doctorScheduleFrom);
            doctorSchedule.setDayOfWeek(dayOfWeek);
            doctorSchedule.setAppointmentsByDoctorScheduleId(appointmentsByDoctorScheduleId);
            doctorSchedule.setDoctorByDoctorId(doctorByDoctorId);
            log.debug("Update Schedule Information:{}", doctorSchedule);
            doctorScheduleRepository.save(doctorSchedule);
        });
    }

    public Optional<DoctorSchedule> getScheduleById(Integer id){
        Optional<DoctorSchedule> doctorSchedule=doctorScheduleRepository.findOneById(id);
        return doctorSchedule;
    }

    public void deleteSchedule(Integer id){
        doctorScheduleRepository.findOneById(id).ifPresent(doctorSchedule->{
            doctorScheduleRepository.delete(doctorSchedule);
            log.debug("Deleted Information:{}", doctorSchedule);
        });
    }
}
