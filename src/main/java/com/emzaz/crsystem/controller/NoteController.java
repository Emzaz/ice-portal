package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/uploadNotes")
    public String getNotes(Model model) {
        List<Note> notes = noteService.getFiles();

        model.addAttribute("notes", notes);
        return "noteUploadForm";
    }

    @PostMapping("/uploadNotes")
    public String uploadNotes(@RequestParam("files")MultipartFile[] files) {
        for (MultipartFile file: files) {
            noteService.saveFile(file);
        }

        return "redirect:/uploadNotes";
    }

    @GetMapping("/downloadNote/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId) {
        Note note = noteService.getFile(fileId).get();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" +note.getNoteName() + "\"")
                .body(new ByteArrayResource(note.getData()));
    }
}
