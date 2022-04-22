package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Attendance;
import com.emzaz.crsystem.model.AttendanceForm;
import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.service.AttendanceService;
import com.emzaz.crsystem.service.CourseService;
import com.emzaz.crsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "courses/{courseId}/attendance")
@Slf4j
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    List<String> batches = Arrays.asList("5th", "6th", "7th", "8th", "9th");

    @GetMapping
    public String showAttendance(@RequestParam(value = "batch",  required = false, defaultValue = "5th")
                                             String batch, @PathVariable("courseId") Long courseId, Model model) {


        model.addAttribute("batches", batches);

        List<Student> studentList = studentService.getAllStudentsByBatch(batch);
        Course course = courseService.getCourseById(courseId);

        List<Attendance> attendanceList = studentList.stream()
                .map(student -> new Attendance(false, course, student))
                .collect(Collectors.toList());

        log.debug("list of attendance: {}", attendanceList);

        AttendanceForm attendanceForm = new AttendanceForm();
        attendanceForm.setAttendances(attendanceList);

        model.addAttribute("attendanceForm", attendanceForm);


        return "attendanceList";
    }

    @PostMapping
    public String countAttendance(@ModelAttribute AttendanceForm attendanceForm, @PathVariable String courseId) {

        List<Attendance> attendances = attendanceForm.getAttendances();

        attendanceService.saveAll(attendances);

        return "redirect:/courses/" + courseId + "/attendance/data";
    }

    @GetMapping("/data")
    public String viewAttendanceData(@PathVariable("courseId") Long courseId, Model model) {

        model.addAttribute("attendanceData", attendanceService.getAllAttendances());
        model.addAttribute("courseId", courseId);

        return "attendanceData";
    }
}
