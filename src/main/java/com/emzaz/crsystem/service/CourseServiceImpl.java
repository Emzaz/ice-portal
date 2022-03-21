package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.repository.CourseRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public List<Course> saveCourse(MultipartFile file) throws IOException {
        File targetFile = saveFileTemporaryLocation(file);

        List<Course> courseList = (List<Course>) new CsvToBeanBuilder(new FileReader(targetFile))
                .withType(Course.class)
                .build()
                .parse();

        return courseRepository.saveAll(courseList);
    }

    private File saveFileTemporaryLocation(MultipartFile file) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File("csv/Courses.csv");

        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }
        return targetFile;
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> optional = courseRepository.findById(id);
        Course course = null;

        if (optional.isPresent()) {
            course = optional.get();
        } else {
            throw new RuntimeException("Course not found by id:: " +id);
        }

        return course;
    }

    @Override
    public void deleteCourseById(Long id) {
        this.courseRepository.deleteById(id);
    }


    @Override
    public List<Course> getAllCoursesBySemester(String semester) {
        return courseRepository.findAllBySemester(semester);
    }
}
