package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendances() {
        return null;
    }

    @Override
    public void saveAttendance(Attendance attendance) {

    }

    @Override
    public void saveAll(List<Attendance> attendances) {
        attendanceRepository.saveAll(attendances);
    }

    @Override
    public Student getAttendanceById(Long id) {
        return null;
    }

    @Override
    public void deleteAttendanceById(Long id) {

    }
}
