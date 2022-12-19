package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.Servicio;
import com.psicodidact.agendamiento.services.IDiscapacidadService;
import com.psicodidact.agendamiento.services.IServicioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ServicioRestController {

	@Autowired
	private IServicioService servicioService;
	
	@GetMapping("/servicio")
	public List<Servicio> index() {
		return servicioService.findAll();
	}
	
	
}
