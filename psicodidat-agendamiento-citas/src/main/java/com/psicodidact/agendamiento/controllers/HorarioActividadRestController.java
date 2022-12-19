package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.HorarioActividad;

import com.psicodidact.agendamiento.services.IHorarioActividadService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class HorarioActividadRestController {

	@Autowired
	private IHorarioActividadService horarioActividad;
	
	@GetMapping("/horarioActividad")
	public List<HorarioActividad> index() {
		return horarioActividad.findAll();
	}
	
	
}
