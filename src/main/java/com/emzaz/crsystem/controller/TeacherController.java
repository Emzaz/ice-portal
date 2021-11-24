package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.model.Teacher;
import com.emzaz.crsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public String showTeachers(Model model) {
        model.addAttribute("listOfTeachers", teacherService.getAllTeachers());

        return "teacherList";
    }

    @GetMapping("/teacherForm")
    public String teacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teacherForm";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);

        return "redirect:/teacher";
    }

    @GetMapping("/updateTeacher/{id}")
    public String updateTeacher(@PathVariable(value = "id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);

        model.addAttribute("teacher", teacher);

        return "updateTeacher";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") Long id) {
        this.teacherService.deleteTeacherById(id);

        return "redirect:/teacher";
    }
}
