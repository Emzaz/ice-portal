package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.model.Student;
import com.emzaz.crsystem.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public void saveNotice(Notice notice) {
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
}
