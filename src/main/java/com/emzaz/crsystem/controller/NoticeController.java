package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Note;
import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "courses/{courseId}/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public String showNotices(@PathVariable Long courseId, Model model) {
        List<Notice> notices = noticeService.getNotices(courseId);

        model.addAttribute("notices", notices);

        return "noticeList";
    }

    @GetMapping("/noticeForm")
    public String noticeForm(@PathVariable Long courseId, Model model) {
        Notice notice = new Notice();

        model.addAttribute("courseId", courseId);

        model.addAttribute("notice", notice);

        return "noticeForm";
    }

    @PostMapping("/saveNotice")
    public String saveNotice(@PathVariable("courseId") Long courseId, @ModelAttribute("notice") Notice notice) {
        noticeService.saveNotice(courseId, notice);

        return "redirect:/courses/" + courseId + "/notice";
    }

    @GetMapping("/updateNotice/{id}")
    public String updateNotice(@PathVariable(value = "id") Long id, @PathVariable Long courseId, Model model) {
        Notice notice = noticeService.getNoticeById(id);

        model.addAttribute("notice", notice);
        model.addAttribute("courseId", courseId);

        return "updateNotice";
    }

    @GetMapping("/deleteNotice/{id}")
    public String deleteNotice(@PathVariable(value = "id") Long id) {
        this.noticeService.deleteNoticeById(id);

        return "redirect:/notice";
    }
}
