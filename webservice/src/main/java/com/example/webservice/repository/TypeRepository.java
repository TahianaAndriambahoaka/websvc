package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.example.webservice.model.Type;


public interface TypeRepository extends JpaRepository<Type, Long> {
  
}