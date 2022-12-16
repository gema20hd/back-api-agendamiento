package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.PacienteProfesional;
import com.psicodidact.agendamiento.services.IPacienteProfesionalService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PacienteProfesionalRestController {
	
	
	@Autowired
	private IPacienteProfesionalService pacienteProfesionalService;
	
	@GetMapping("/pacienteProfesional")
	public List<PacienteProfesional> index() {
		return pacienteProfesionalService.findAll();
	}

}
