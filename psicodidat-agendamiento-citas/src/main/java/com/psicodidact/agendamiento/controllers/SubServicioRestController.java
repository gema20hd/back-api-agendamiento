package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.SubServicio;
import com.psicodidact.agendamiento.services.ISubServicioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SubServicioRestController {

	
	@Autowired
	private ISubServicioService subServicioService;
	
	@GetMapping("/subServicio")
	public List<SubServicio> index() {
		return subServicioService.findAll();
	}
	
	
	
}
