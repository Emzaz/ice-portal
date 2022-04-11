package com.emzaz.crsystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean present;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    @Temporal(value = TemporalType.DATE)
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    public Attendance() {
    }

    public Attendance(boolean present, Course course, Student student, Date date) {
        this.present = present;
        this.course = course;
        this.student = student;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
