package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    void saveStudent(Student student);
    List<Student> saveStudent(MultipartFile file) throws IOException;
    Student getStudentById(Long id);
    void deleteStudentById(Long id);

    List<Student> getAllStudentsByBatch(String batch);
}
