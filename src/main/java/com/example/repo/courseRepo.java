package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.course;
@Repository
public interface courseRepo extends JpaRepository<course, Integer>{

}
