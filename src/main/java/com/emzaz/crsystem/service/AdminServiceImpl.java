package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Admin;
import com.emzaz.crsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void saveAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        Optional<Admin> optional = adminRepository.findById(id);
        Admin admin = null;

        if (optional.isPresent()) {
            admin = optional.get();
        } else {
            throw new RuntimeException("Admin not found for id :: " +id);
        }

        return admin;
    }

    @Override
    public void deleteAdminById(Long id) {
        this.adminRepository.deleteById(id);
    }
}
