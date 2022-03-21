package com.emzaz.crsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String session;
    private String studentName;
    private String studentId;
    private Long year;
    private Long term;
    private String courseCode;
    private String courseTitle;
    private float credits;
    private float gradePoints;
    private String grade;

    public Result() {
    }

    public Result(Long id, String session, String studentName, String studentId, Long year, Long term,
                  String courseCode, String courseTitle, float credits, float gradePoints, String grade,
                  Long creditsTaken, Long creditsCompleted, Long cumulativeCredits, float TGPA, float CGPA) {
        this.id = id;
        this.session = session;
        this.studentName = studentName;
        this.studentId = studentId;
        this.year = year;
        this.term = term;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.gradePoints = gradePoints;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
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

    public float getGradePoints() {
        return gradePoints;
    }

    public void setGradePoints(float gradePoints) {
        this.gradePoints = gradePoints;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
