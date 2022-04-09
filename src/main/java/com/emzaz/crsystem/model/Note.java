package com.emzaz.crsystem.model;

import org.hibernate.annotations.Type;
import org.hibernate.type.BlobType;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String noteName;
    private String noteType;

    @Lob
    @Column(name="data", columnDefinition="BLOB",  length = 65555)
    private byte[] data;

    @ManyToOne
    private Course course;

    public Note() {
    }

    public Note(String noteName, String noteType, byte[] data) {
        this.noteName = noteName;
        this.noteType = noteType;
        this.data = data;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
