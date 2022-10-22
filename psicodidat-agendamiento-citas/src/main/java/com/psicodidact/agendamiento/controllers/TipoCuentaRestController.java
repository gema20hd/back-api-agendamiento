package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.Trabajo;
import com.psicodidact.agendamiento.services.ITipoCuentaService;
import com.psicodidact.agendamiento.services.ITrabajoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoCuentaRestController {

	@Autowired
	private ITipoCuentaService tipoCuenta;
	
	@GetMapping("/TipoCuenta")
	public List<TipoCuenta> index() {
		return tipoCuenta.findAll();
	}
}
