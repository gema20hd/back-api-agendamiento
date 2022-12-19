package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.Pago;
import com.psicodidact.agendamiento.services.IPagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PagoRestController {

	
	@Autowired
	private IPagoService pagoService;
	
	@GetMapping("/pago")
	public List<Pago> index() {
		return pagoService.findAll();
	}
	
}
