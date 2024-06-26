package com.example.TestSpring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.example.TestSpring.dtos.DegreeDTO;
import com.example.TestSpring.entities.Degree;
import com.example.TestSpring.services.IDegreeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/degrees")
public class DegreeController {
	
	private IDegreeService degreeService;
	
	public DegreeController(IDegreeService degreeService) {
		this.degreeService = degreeService;
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEGREE_INDEX);
		mAV.addObject("degrees", degreeService.getAll());
		//mAV.addObject("degree", new DegreeDTO());
		
		return mAV;
	}

	
	@PostMapping("/") 
	public RedirectView create(@ModelAttribute("degree") DegreeDTO degreeDTO) {
		
		degreeService.insertOrUpdate(degreeDTO);
		return new RedirectView(ViewRouteHelper.DEGREE_ROOT);
	}
	
	@GetMapping("/form")
	public String degree(Model model) {
		//model.addAttribute("degree", new DegreeDTO());
		return ViewRouteHelper.DEGREE_FORM;
	}

	@PostMapping("/new")
	public ModelAndView newdegree(@Valid @ModelAttribute("degree") DegreeDTO degree, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DEGREE_FORM);
		} else {
			mV.setViewName(ViewRouteHelper.DEGREE_NEW);
			mV.addObject("degree", degree);
		}
		return mV;
	}
	DegreeDTO degree = new DegreeDTO(1, "", "", 0);
	
	
	
	}
