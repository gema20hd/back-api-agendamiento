package com.psicodidact.agendamiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoTrabajo;
import com.psicodidact.agendamiento.services.ITipoDiscapacidadService;
import com.psicodidact.agendamiento.services.ITipoTrabajoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoTrabajoRestController {

	
	@Autowired
	private ITipoTrabajoService iTipoTrabajoService;
	

	@GetMapping("/tiposTrabajos")
	public List<TipoTrabajo> index() {
		return iTipoTrabajoService.findAll();
	}
	
	
	
	
	@PostMapping(value = "/tiposTrabajos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarTipoTrabajo(@RequestBody TipoTrabajo tipoTrabajo){
		Map<String, Object> response = new HashMap<>();
		TipoTrabajo tipoTrabajoNuevo=null;
		try {
	
	
	
			tipoTrabajoNuevo=iTipoTrabajoService.save(tipoTrabajo);		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
				
		
		response.put("mensaje", "Registro Trabajo ha sido creado con exito");
		response.put("tipoTrabajo", tipoTrabajoNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/tiposTrabajos/{id_TipoTrabajo}")
	public ResponseEntity<?>  obtenerTipoTrabajoById( @PathVariable("id_TipoTrabajo") Long id_TipoTrabajo) {
		Map<String, Object> response = new HashMap<>();
		TipoTrabajo tipoTrabajoNuevo=null;
		try {
			tipoTrabajoNuevo=iTipoTrabajoService.findById(id_TipoTrabajo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (tipoTrabajoNuevo == null) {
			response.put("mensaje", "El representante ID ".concat(id_TipoTrabajo.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("se le responde "+tipoTrabajoNuevo);
		return new ResponseEntity<TipoTrabajo>(tipoTrabajoNuevo, HttpStatus.OK);
	} 
	
	
	
}
