package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoticeService {
    List<Notice> getAllNotices();
    void saveNotice(Notice notice);
//    List<Student> saveStudent(MultipartFile file) throws IOException;
    Notice getNoticeById(Long id);
    void deleteNoticeById(Long id);
}
