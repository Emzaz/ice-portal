package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Result;
import com.emzaz.crsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/result")
    public String showResult(Model model) {
        model.addAttribute("listOfResults", resultService.getAllResults());

        return "resultList";
    }

    @GetMapping("/resultForm")
    public String resultForm(Model model) {
        Result result = new Result();
        model.addAttribute("result", result);

        return "resultForm";
    }

    @PostMapping("/saveResult")
    public String saveResult(@ModelAttribute("result") Result result) {
        resultService.saveResult(result);

        return "redirect:/result";
    }

    @GetMapping("/updateResult/{id}")
    public String updateResult(@PathVariable(value = "id") Long id, Model model) {
        Result result = resultService.getResultById(id);

        model.addAttribute("result", result);

        return "updateResult";
    }

    @GetMapping("/deleteResult/{id}")
    public String deleteResult(@PathVariable(value = "id") Long id) {
        this.resultService.deleteResultById(id);

        return "redirect:/result";
    }
}
