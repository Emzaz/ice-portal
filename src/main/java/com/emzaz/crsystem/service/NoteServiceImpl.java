package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.repository.CourseRepository;
import com.emzaz.crsystem.repository.NoteRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Note saveFile(Long courseId, MultipartFile file) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("course id not found"));

        String noteName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Note note = new Note(noteName, file.getContentType(), file.getBytes());
            note.setCourse(course);
            return noteRepository.save(note);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Note> getFile(Long fileId) {
        return noteRepository.findById(fileId);
    }

    @Override
    public List<Note> getNotes(Long courseId) {
        return noteRepository.findByCourseId(courseId);
    }
}
