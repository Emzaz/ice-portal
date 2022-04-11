package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Override
    public List<Attendance> getAllAttendances() {
        return null;
    }

    @Override
    public void saveAttendance(Attendance attendance) {

    }

    @Override
    public Student getAttendanceById(Long id) {
        return null;
    }

    @Override
    public void deleteAttendanceById(Long id) {

    }
}
