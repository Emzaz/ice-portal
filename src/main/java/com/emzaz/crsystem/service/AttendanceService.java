package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.Student;

import java.util.Date;
import java.util.List;

public interface AttendanceService {

    List<Attendance> getAllAttendances(Long courseId, String batch, Date date);
    void saveAttendance(Attendance attendance);
    void saveAll(List<Attendance> attendances);

    Student getAttendanceById(Long id);
    void deleteAttendanceById(Long id);

}
