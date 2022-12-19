package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.psicodidact.agendamiento.models.entity.ServicioCompra;
import com.psicodidact.agendamiento.services.IServicioCompraService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ServicioCompraRestController {


	@Autowired
	private IServicioCompraService servicioCompraService;
	
	@GetMapping("/servicioCompra")
	public List<ServicioCompra> index() {
		return servicioCompraService.findAll();
	}
	
	
	
}
