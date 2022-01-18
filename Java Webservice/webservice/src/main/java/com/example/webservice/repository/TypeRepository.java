package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
