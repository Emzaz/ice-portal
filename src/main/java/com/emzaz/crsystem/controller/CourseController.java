package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public String showCourses( Model model) {
        model.addAttribute("listOfCourses", courseService.getAllCourses());

        return "courseList";
    }

    @GetMapping("/courseForm")
    public String courseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);

        return "courseForm";
    }

    @GetMapping("/uploadCourse")
    public String uploadCourse() {

        return "courseCsvForm";
    }

    @PostMapping("/uploadCourse")
    public String saveCourseCsv(@RequestParam("file") MultipartFile file) throws IOException {
        courseService.saveCourse(file);

        return "redirect:/course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);

        return "redirect:/course";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable(value = "id") Long id, Model model) {
        Course course = courseService.getCourseById(id);

        model.addAttribute("course", course);

        return "updateCourse";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") Long id) {
        this.courseService.deleteCourseById(id);

        return "redirect:/course";
    }
}
