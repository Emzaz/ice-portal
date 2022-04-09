package com.emzaz.crsystem.repository;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByCourseId(Long courseId);
}
