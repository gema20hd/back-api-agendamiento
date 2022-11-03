package com.psicodidact.agendamiento.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.services.IActividadService;
import com.psicodidact.agendamiento.services.ICuentaService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CuentaRestController {


	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping("/cuenta")
	public List<Cuenta> index() {
		return cuentaService.findAll();
	}
	
	
}