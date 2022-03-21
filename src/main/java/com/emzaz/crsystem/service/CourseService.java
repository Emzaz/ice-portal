package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    void saveCourse(Course course);
    List<Course> saveCourse(MultipartFile file) throws IOException;
    Course getCourseById(Long id);
    void deleteCourseById(Long id);

    List<Course> getAllCoursesBySemester(String semester);
}
