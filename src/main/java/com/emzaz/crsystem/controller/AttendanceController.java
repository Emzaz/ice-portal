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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
    public String showAttendance(@RequestParam(value = "batch", required = false, defaultValue = "5th")
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
    public String viewAttendanceData(@RequestParam(value = "batch", required = false) String batch,
                                     @RequestParam(value = "date", required = false) String date,
                                     @PathVariable("courseId") Long courseId, Model model) throws ParseException {


        model.addAttribute("batches", batches);

        Date dateObject;

        if (!StringUtils.hasText(date)) {
            dateObject = new Date();
        } else {
            dateObject = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }

        List<Attendance> attendances = attendanceService.getAllAttendances(courseId, batch, dateObject);
        model.addAttribute("attendanceData", attendances);

        return "attendanceData";
    }

    @GetMapping("/data/download")
    public void downloadAttendanceData(HttpServletResponse response, @RequestParam(value = "batch", required = false) String batch,
                                       @RequestParam(value = "date", required = false) String date,
                                       @PathVariable("courseId") Long courseId, Model model) throws ParseException, IOException {

        Date dateObject;
        if (!StringUtils.hasText(date)) {
            dateObject = new Date();
        } else {
            dateObject = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }

        List<Attendance> attendances = attendanceService.getAllAttendances(courseId, batch, dateObject);
        model.addAttribute("attendanceData", attendances);

        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=attendance_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);


        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Course Code", "Student Id", "Batch", "Date", "Present"};
        String[] nameMapping = {"Course Code", "Student Id", "Batch", "Date", "Present"};

        csvWriter.writeHeader(csvHeader);

        for (Attendance attendance: attendances) {
            csvWriter.write(attendance, nameMapping);
        }

        csvWriter.close();

    }
}
