package com.example.TestSpring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TestSpring.entities.Degree;

@Repository("degreeRepository")
public interface IDegreeRepository extends JpaRepository<Degree, Serializable> {
	
	public abstract Degree findByName(String name);
	
	public abstract Degree findByInstitutionAndYear(String institution, int year);
	
	public abstract Degree findByInstitutionAndYearOrderByYearDesc(String institution, int year);
	
	
}
