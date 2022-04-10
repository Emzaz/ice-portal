package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.model.Notice;
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
@RequestMapping(value = "courses/{courseId}/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String showNotes(@PathVariable Long courseId, Model model) {
        List<Note> notes = noteService.getNotes(courseId);

        model.addAttribute("notes", notes);

        return "noteList";
    }

    @GetMapping("/noteForm")
    public String getNotes(@PathVariable Long courseId, Model model) {
        List<Note> notes = noteService.getNotes(courseId);

        model.addAttribute("notes", notes);
        model.addAttribute("courseId", courseId);
        return "noteUploadForm";
    }

    @PostMapping("/upload")
    public String uploadNotes(@PathVariable("courseId") Long courseId, @RequestParam("files")MultipartFile[] files) {
        for (MultipartFile file: files) {
            noteService.saveFile(courseId, file);
        }

        return "redirect:/courses/" + courseId + "/notes";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId) {
        Note note = noteService.getFile(fileId).get();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" +note.getNoteName() + "\"")
                .body(new ByteArrayResource(note.getData()));
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("courseId") Long courseId, @PathVariable(value = "id") Long id) {
        this.noteService.deleteNoteById(id);

        return "redirect:/courses/" + courseId + "/notes";
    }
}
