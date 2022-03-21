package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
    void saveAdmin(Admin admin);
    Admin getAdminById(Long id);
    void deleteAdminById(Long id);
}
