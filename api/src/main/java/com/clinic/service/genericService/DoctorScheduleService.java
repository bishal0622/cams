package com.clinic.service.genericService;

import com.clinic.domain.DoctorSchedule;
import com.clinic.repository.DoctorScheduleRepository;
import com.clinic.service.dto.DoctorScheduleDTO;
import com.clinic.service.generic.DoctorScheduleGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by japnica on 12/25/2016.
 */
@Service
@Transactional
public class DoctorScheduleService implements DoctorScheduleGeneric{
    @Inject
    DoctorScheduleRepository doctorScheduleRepository;

    private final Logger log = LoggerFactory.getLogger(DoctorScheduleService.class);

//    public Optional<DoctorSchedule> getScheduleById(Integer id){
//        Optional<DoctorSchedule> doctorSchedule=doctorScheduleRepository.findOneById(id);
//        return doctorSchedule;
//    }

    @Override
    public DoctorSchedule save(DoctorScheduleDTO doctorScheduleDTO) {
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

    @Override
    public List<DoctorSchedule> getAll() {
        List<DoctorSchedule> doctorSchedules=doctorScheduleRepository.findAll();
        return doctorSchedules;
    }

    @Override
    public void update(DoctorScheduleDTO doctorScheduleDTO) {
        doctorScheduleRepository.findOneById(doctorScheduleDTO.getId()).ifPresent(doctorSchedule -> {
            doctorSchedule.setDoctorScheduleTo(doctorScheduleDTO.getDoctorScheduleTo());
            doctorSchedule.setDoctorScheduleFrom(doctorScheduleDTO.getDoctorScheduleFrom());
            doctorSchedule.setDayOfWeek(doctorScheduleDTO.getDayOfWeek());
            doctorSchedule.setAppointmentsByDoctorScheduleId(doctorScheduleDTO.getAppointmentsByDoctorScheduleId());
            doctorSchedule.setDoctorByDoctorId(doctorScheduleDTO.getDoctorByDoctorId());
            log.debug("Update Schedule Information:{}", doctorSchedule);
            doctorScheduleRepository.save(doctorSchedule);
        });
    }

    @Override
    public DoctorSchedule findOne(int id) {
        return doctorScheduleRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        doctorScheduleRepository.findOneById(id).ifPresent(doctorSchedule->{
            doctorScheduleRepository.delete(doctorSchedule);
            log.debug("Deleted Information:{}", doctorSchedule);
        });
    }
}
