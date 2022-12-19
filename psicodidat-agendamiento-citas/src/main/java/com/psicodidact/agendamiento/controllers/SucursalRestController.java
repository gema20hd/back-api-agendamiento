package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Sucursal;
import com.psicodidact.agendamiento.services.ISucursalService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SucursalRestController {
	@Autowired
	private ISucursalService isucursal;
	
	@GetMapping("/sucursal")
	public List<Sucursal> index() {
		return isucursal.findAll();
	}
	
	
}
