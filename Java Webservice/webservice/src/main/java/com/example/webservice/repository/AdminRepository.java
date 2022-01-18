package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
