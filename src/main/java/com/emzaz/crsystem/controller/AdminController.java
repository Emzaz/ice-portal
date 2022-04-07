package com.emzaz.crsystem.controller;

import com.emzaz.crsystem.model.Admin;
import com.emzaz.crsystem.service.AdminService;
import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/adminList")
    public String showAdmin(Model model) {
        model.addAttribute("listOfAdmins", adminService.getAllAdmins());

        return "adminList";
    }

    @GetMapping("/adminForm")
    public String adminForm(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);

        return "adminForm";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.saveAdmin(admin);

        return "redirect:/admin";
    }

    @GetMapping("/updateAdmin/{id}")
    public String updateAdmin(@PathVariable(value = "id") Long id, Model model) {
        Admin admin = adminService.getAdminById(id);

        model.addAttribute("admin", admin);

        return "updateAdmin";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(value = "id") Long id) {
        this.adminService.deleteAdminById(id);

        return "redirect:/admin";
    }
}
