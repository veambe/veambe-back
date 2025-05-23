package com.proyecto.veambe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.veambe.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
