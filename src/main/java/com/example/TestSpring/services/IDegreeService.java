package com.example.TestSpring.services;

import java.util.List;

import com.example.TestSpring.dtos.DegreeDTO;
import com.example.TestSpring.entities.Degree;

public interface IDegreeService {
	
	public List<Degree> getAll();
	
	public DegreeDTO insertOrUpdate(DegreeDTO degreeModel);
	
	public boolean remove(int id);
}
