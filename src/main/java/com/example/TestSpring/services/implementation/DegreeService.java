package com.example.TestSpring.services.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.TestSpring.dtos.DegreeDTO;
import com.example.TestSpring.entities.Degree;

import com.example.TestSpring.repositories.IDegreeRepository;
import com.example.TestSpring.services.IDegreeService;


@Service("degreeService")
public class DegreeService implements IDegreeService{
	
	private IDegreeRepository degreeRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public DegreeService(IDegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
	}
	
	@Override
	public List<Degree> getAll(){
		return degreeRepository.findAll();
	}
	
	@Override
	public DegreeDTO insertOrUpdate(DegreeDTO degreeDTO) {
		Degree degree = degreeRepository.save(modelMapper.map(degreeDTO, Degree.class));
		return modelMapper.map(degree, DegreeDTO.class);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id);;
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	
}
