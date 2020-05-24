package com.settlement.demo.service;

import com.settlement.demo.model.Admin;
import com.settlement.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public Admin saveAdmin(@Validated Admin admin) {
        return this.adminRepository.save(admin);
    }

    public Admin findAdminByAdminId(Long id) {
        return this.adminRepository.findById(id).orElse(null);
    }

    public List<Admin> findAllAdmin() {
        return this.adminRepository.findAll();
    }

    public Admin findAdminByEmail(@NotBlank String email) {
        return this.adminRepository.findAdminByEmail(email);
    }

}
