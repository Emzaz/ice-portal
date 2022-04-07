package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Note;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    Note saveFile(MultipartFile file);
    Optional<Note> getFile(Long fileId);
    List<Note> getFiles();
}
