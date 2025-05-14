package com.proyecto.veambe.controller;

import org.springframework.web.bind.annotation.RestController;
import com.proyecto.veambe.model.Admin;
import com.proyecto.veambe.repository.AdminRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
  private final AdminRepository adminRepository;

  public AdminController(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @PostMapping
  public Admin creatAdmin(@RequestBody Admin admin) {
    return adminRepository.save(admin);
  }
}
