package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.model.Teacher;
import com.emzaz.crsystem.repository.TeacherRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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

    @Override
    public List<Teacher> saveTeacher(MultipartFile file) throws IOException {
        File targetFile = saveFileTemporaryLocation(file);

        List<Teacher> teacherList = (List<Teacher>) new CsvToBeanBuilder(new FileReader(targetFile))
                .withType(Teacher.class)
                .build()
                .parse();

        return teacherRepository.saveAll(teacherList);
    }

    private File saveFileTemporaryLocation(MultipartFile file) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File("csv/teacher.csv");

        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }
        return targetFile;
    }
}
