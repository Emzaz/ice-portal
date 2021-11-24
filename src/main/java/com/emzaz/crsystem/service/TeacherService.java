package com.emzaz.crsystem.service;


import com.emzaz.crsystem.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    void deleteTeacherById(Long id);
}
