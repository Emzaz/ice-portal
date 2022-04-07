package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Notice;
import com.emzaz.crsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String showNotices(Model model) {
        model.addAttribute("listOfNotices", noticeService.getAllNotices());

        return "noticeList";
    }

    @GetMapping("/noticeForm")
    public String noticeForm(Model model) {
        Notice notice = new Notice();
        model.addAttribute("notice", notice);

        return "noticeForm";
    }

    @PostMapping("/saveNotice")
    public String saveNotice(@ModelAttribute("notice") Notice notice) {
        noticeService.saveNotice(notice);

        return "redirect:/notice";
    }

    @GetMapping("/updateNotice/{id}")
    public String updateNotice(@PathVariable(value = "id") Long id, Model model) {
        Notice notice = noticeService.getNoticeById(id);

        model.addAttribute("notice", notice);

        return "updateNotice";
    }

    @GetMapping("/deleteNotice/{id}")
    public String deleteNotice(@PathVariable(value = "id") Long id) {
        this.noticeService.deleteNoticeById(id);

        return "redirect:/notice";
    }
}
