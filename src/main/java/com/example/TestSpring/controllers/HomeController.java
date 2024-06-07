package com.example.TestSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TestSpring.entities.Degree;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return ViewRouteHelper.INDEX;
	}

	@GetMapping("/hello")
	public ModelAndView helloParams1(
			@RequestParam(name = "name", required = false, defaultValue = "null") String name) {

		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}

	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {

		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}

	@GetMapping("/")
	public RedirectView redirectViewToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}

	@GetMapping("/degree")
	public String degree(Model model) {
		model.addAttribute("degree", new Degree());
		return ViewRouteHelper.DEGREE_INDEX;
	}

	@PostMapping("/newdegree")
	public ModelAndView newdegree(@Valid @ModelAttribute("degree") Degree degree, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DEGREE_FORM);
		} else {
			mV.setViewName(ViewRouteHelper.DEGREE_NEW);
			mV.addObject("degree", degree);
		}

		return mV;
	}

}
