package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Course;
import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.repository.CourseRepository;
import com.emzaz.crsystem.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public void saveNotice(Long courseId, Notice notice) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("course id not found"));

        notice.setCourse(course);

        this.noticeRepository.save(notice);
    }

    @Override
    public Notice getNoticeById(Long id) {
        Optional<Notice> optional = noticeRepository.findById(id);
        Notice notice = null;

        if(optional.isPresent()) {
            notice = optional.get();
        } else {
            throw new RuntimeException("Notice not found for id:: " +id);
        }

        return notice;
    }

    @Override
    public void deleteNoticeById(Long id) {
        this.noticeRepository.deleteById(id);
    }

    @Override
    public List<Notice> getNotices(Long courseId) {
        return noticeRepository.findByCourseId(courseId);
    }
}
