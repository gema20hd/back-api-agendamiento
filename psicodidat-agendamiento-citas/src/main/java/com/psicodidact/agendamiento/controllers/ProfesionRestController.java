package com.psicodidact.agendamiento.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Profesion;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.services.IProfesionService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProfesionRestController {


	@Autowired
	private IProfesionService profesionService;
	
	@GetMapping("/profesiones")
	public List<Profesion> index() {
		return profesionService.findAll();
	}
	

	@GetMapping("/profesiones/nombre/{nombre}") 
	@ResponseStatus(HttpStatus.OK)
	public List<Profesion> findByDescripcionProfesionContainingIgnoreCase(@PathVariable("nombre") String term) {
		return profesionService.findByDescripcionProfesionContainingIgnoreCase(term);
	}
	
	
}
