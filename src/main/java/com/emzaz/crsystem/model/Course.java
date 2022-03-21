package com.emzaz.crsystem.model;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CsvBindByPosition(position = 0)
    private String courseCode;

    @CsvBindByPosition(position = 1)
    private String courseTitle;

    @CsvBindByPosition(position = 2)
    private float credits;

    @CsvBindByPosition(position = 3)
    private String semester;

    public Course() {
    }

    public Course(long id, String courseCode, String courseTitle, float credits, String semester) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }
}
