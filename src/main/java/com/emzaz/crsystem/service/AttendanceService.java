package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.Student;
import java.util.List;

public interface AttendanceService {

    List<Attendance> getAllAttendances();
    void saveAttendance(Attendance attendance);

    Student getAttendanceById(Long id);
    void deleteAttendanceById(Long id);
}
