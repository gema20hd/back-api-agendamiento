package com.psicodidact.agendamiento.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Profesion;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.services.IProfesionProfesionalService;
import com.psicodidact.agendamiento.services.IProfesionService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProfesionProfesionalRestController {


	@Autowired
	private IProfesionProfesionalService profesionProfesionalService;
	
	@GetMapping("/profesionProfesionales")
	public List<ProfesionProfesional> index() {
		return profesionProfesionalService.findAll();
	}
	
	
}
