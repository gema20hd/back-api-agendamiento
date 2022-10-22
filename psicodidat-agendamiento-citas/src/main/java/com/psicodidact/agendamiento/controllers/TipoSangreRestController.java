package com.psicodidact.agendamiento.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoSangre;
import com.psicodidact.agendamiento.models.repository.ITipoSangreRepository;
import com.psicodidact.agendamiento.services.IProfesionalService;
import com.psicodidact.agendamiento.services.ITipoSangreService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoSangreRestController {


	@Autowired
	private ITipoSangreService tipoSangreService;
	
	@GetMapping("/profesionales")
	public List<TipoSangre> index() {
		return tipoSangreService.findAll();
	}
	
	
}
