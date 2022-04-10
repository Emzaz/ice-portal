package com.emzaz.crsystem.service;


import com.emzaz.crsystem.model.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    List<Teacher> saveTeacher(MultipartFile file) throws IOException;
    Teacher getTeacherById(Long id);
    void deleteTeacherById(Long id);
}
