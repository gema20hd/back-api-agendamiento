package com.psicodidact.agendamiento.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Antecedente;
import com.psicodidact.agendamiento.services.IAntecedentesService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AntecedenteRestController {


	@Autowired
	private IAntecedentesService antecedenteService;
	
	@GetMapping("/antecedente")
	public List<Antecedente> index() {
		return antecedenteService.findAll();
	}
	
	
}