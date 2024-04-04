package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.person;


public interface personRepo extends JpaRepository<person, Integer>{

	@Query("select p from person p where p.pname=:pname")
	public person getByName(String pname);
}
