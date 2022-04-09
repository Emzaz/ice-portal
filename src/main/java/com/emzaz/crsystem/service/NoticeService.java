package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoticeService {

    void saveNotice(Long courseId, Notice notice);

    Notice getNoticeById(Long id);
    void deleteNoticeById(Long id);

    List<Notice> getNotices(Long courseId);
}
