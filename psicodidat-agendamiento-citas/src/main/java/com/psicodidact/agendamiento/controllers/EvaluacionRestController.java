package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.Evaluacion;
import com.psicodidact.agendamiento.services.IEvaluacionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EvaluacionRestController {


	@Autowired
	private IEvaluacionService evaluacionService;
	
	@GetMapping("/evaluacion")
	public List<Evaluacion> index() {
		return evaluacionService.findAll();
	}
	
	
}
