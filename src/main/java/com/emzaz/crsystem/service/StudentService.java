package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
}
