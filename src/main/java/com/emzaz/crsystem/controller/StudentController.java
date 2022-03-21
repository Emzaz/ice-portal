package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String showStudents(Model model) {
        model.addAttribute("listOfStudents", studentService.getAllStudents());

        return "studentList";
    }

    @GetMapping("/studentForm")
    public String studentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "studentForm";
    }

    @GetMapping("/uploadStudent")
    public String uploadStudent() {

        return "studentCsvForm";
    }

    @PostMapping("/uploadStudent")
    public String saveStudentCsv(@RequestParam("file") MultipartFile file) throws IOException {
        studentService.saveStudent(file);

        return "redirect:/student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);

        return "redirect:/student";
    }

    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "updateStudent";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        this.studentService.deleteStudentById(id);

        return "redirect:/student";
    }

}
