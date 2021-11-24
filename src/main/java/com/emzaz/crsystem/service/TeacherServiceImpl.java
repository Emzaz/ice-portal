package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.model.Teacher;
import com.emzaz.crsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        Teacher teacher = null;

        if(optional.isPresent()) {
            teacher = optional.get();
        } else {
            throw new RuntimeException("Teacher not found for id:: " +id);
        }

        return teacher;
    }

    @Override
    public void deleteTeacherById(Long id) {
        this.teacherRepository.deleteById(id);
    }
}
