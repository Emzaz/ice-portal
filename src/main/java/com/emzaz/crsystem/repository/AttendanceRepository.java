package com.emzaz.crsystem.repository;

import com.emzaz.crsystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAttendanceByCourseAndStudent(Long courseId, Long studentId);

}
