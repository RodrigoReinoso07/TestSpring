package com.example.TestSpring.entities;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Degree {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="institution")
	private String institution;
	
	@Column(name="year")
	private int year;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(name="updatedat")
	@CreationTimestamp
	private LocalDate updatedAt;
	
}
