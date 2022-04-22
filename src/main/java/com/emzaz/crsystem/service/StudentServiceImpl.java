package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.repository.StudentRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public List<Student> saveStudent(MultipartFile file) throws IOException {
        File targetFile = saveFileTemporaryLocation(file);

        List<Student> studentList = (List<Student>) new CsvToBeanBuilder(new FileReader(targetFile))
                .withType(Student.class)
                .build()
                .parse();

        return studentRepository.saveAll(studentList);
    }

    private File saveFileTemporaryLocation(MultipartFile file) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File("csv/student.csv");

        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }
        return targetFile;
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;

        if(optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Student not found for id:: " +id);
        }

        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsByBatch(String batch) {
        return studentRepository.findAllByBatch(batch);
    }
}
