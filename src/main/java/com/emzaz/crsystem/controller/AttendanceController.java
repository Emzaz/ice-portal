package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.service.AttendanceService;
import com.emzaz.crsystem.service.CourseService;
import com.emzaz.crsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "courses/{courseId}/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String showAttendance(@PathVariable("courseId") Long courseId, Model model) {
        List<Student> studentList = studentService.getAllStudents();
        List<Attendance> attendanceList = new ArrayList<>();
        Course course = courseService.getCourseById(courseId);

        for (Student student : studentList) {
            Attendance attendance = new Attendance();
            attendance.setCourse(course);
            attendance.setStudent(student);

            attendanceList.add(attendance);
        }

        model.addAttribute("attendanceList", attendanceList);

        return "attendanceList";
    }

    @PostMapping
    public String countAttendance(@PathVariable("courseId") Long courseId, @RequestBody List<Attendance> attendanceList) {
        return null;
    }
}
