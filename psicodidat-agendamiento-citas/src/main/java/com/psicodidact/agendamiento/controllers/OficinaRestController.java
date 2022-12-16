package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.psicodidact.agendamiento.models.entity.Oficina;
import com.psicodidact.agendamiento.services.IOficinaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OficinaRestController {

	
	@Autowired
	private IOficinaService oficinaService;
	
	@GetMapping("/oficina")
	public List<Oficina> index() {
		return oficinaService.findAll();
	}
}
