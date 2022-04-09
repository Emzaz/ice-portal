package com.emzaz.crsystem.repository;

import com.emzaz.crsystem.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCourseId(Long courseId);
}
