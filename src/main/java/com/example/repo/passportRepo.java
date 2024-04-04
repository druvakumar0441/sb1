package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.passport;

@Repository
public interface passportRepo extends JpaRepository<passport, Integer>{

}
