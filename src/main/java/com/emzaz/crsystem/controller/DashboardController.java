package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.service.CourseService;
import com.emzaz.crsystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private NoticeService noticeService;

    List<String> semesters = Arrays.asList("1-1", "1-2", "2-1", "2-2", "3-1", "3-2", "4-1", "4-2");

    @GetMapping
    public String home(@RequestParam(value = "semester",  required = false, defaultValue = "1-1") String semester, Model model) {
        model.addAttribute("semesters", semesters);
        model.addAttribute("listOfCourses", courseService.getAllCoursesBySemester(semester));

        model.addAttribute("listOfNotices", noticeService.getAllNotices());

        return "home";
    }
}
