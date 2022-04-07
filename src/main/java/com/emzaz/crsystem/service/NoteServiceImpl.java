package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note saveFile(MultipartFile file) {
        String noteName = file.getOriginalFilename();

        try {
            Note note = new Note(noteName, file.getContentType(), file.getBytes());
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
    public List<Note> getFiles() {
        return noteRepository.findAll();
    }
}
