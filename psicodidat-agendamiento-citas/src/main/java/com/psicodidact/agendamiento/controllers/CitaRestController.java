package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Cita;

import com.psicodidact.agendamiento.services.ICitaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CitaRestController {

	@Autowired
	private ICitaService citaService;
	
	@GetMapping("/cita")
	public List<Cita> index() {
		return citaService.findAll();
	}
}
