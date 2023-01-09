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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Trabajo;
import com.psicodidact.agendamiento.services.ITrabajoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TrabajoRestController {

	@Autowired
	private ITrabajoService trabajoService;
	
	@GetMapping("/trabajos")
	public List<Trabajo> index() {
		return trabajoService.findAll();
	}
	
	@PostMapping(value = "/trabajos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarTrabajo(@RequestBody Trabajo trabajo){
		Map<String, Object> response = new HashMap<>();
		Trabajo trabajoNuevo=null;
	
		try {
	
			trabajo.setDireccionTrabajo(trabajo.getDireccionTrabajo().toUpperCase());
			trabajo.setDescripcionTrabajo(trabajo.getDescripcionTrabajo().toUpperCase());

			
			trabajoNuevo=trabajoService.save(trabajo);		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
				
		
		response.put("mensaje", "Registro Trabajo ha sido creado con exito");
		response.put("trabajo", trabajoNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/trabajos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> actualizarTrabajo(@RequestBody Trabajo trabajo,@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Trabajo trabajoActual=trabajoService.findById(id);
		Trabajo trabajoActualizado=null;
		
		if (trabajoActual == null) {
			response.put("mensaje", "Error: no se pudo editar , trabajo con ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		
		try {
			trabajoActual.setDireccionTrabajo(trabajo.getDireccionTrabajo().toUpperCase());
			trabajoActual.setDescripcionTrabajo(trabajo.getDescripcionTrabajo().toUpperCase());
			trabajoActual.setIdTrabajo(trabajo.getIdTrabajo());
			trabajoActual.setTipoTrabajo(trabajo.getTipoTrabajo());
			
        
			trabajoActualizado=trabajoService.actualizar(trabajoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El trabajo ha sido actualizado con exito");
		response.put("trabajo", trabajoActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
