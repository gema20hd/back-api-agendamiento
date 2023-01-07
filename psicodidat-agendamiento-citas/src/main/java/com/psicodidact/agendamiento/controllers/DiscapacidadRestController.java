package com.psicodidact.agendamiento.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.services.IDiscapacidadService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DiscapacidadRestController {


	@Autowired
	private IDiscapacidadService discapacidadService;
	
	@GetMapping("/discapacidades")
	public List<Discapacidad> index() {
		return discapacidadService.findAll();
	}
	
	@GetMapping("/discapacidades/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		Discapacidad discapacidad = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			discapacidad = discapacidadService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(discapacidad == null) {
			response.put("mensaje", "La Discapacidad con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Discapacidad>(discapacidad, HttpStatus.OK);
	}
	
	
	//@Secured("ROLE_ADMIN")
		@GetMapping("/discapacidades/tipoDiscapacidades")
		public List<TipoDiscapacidad> findAllTypeDisability(){
			return this.discapacidadService.findAllTypeDisability();
		}
		
		//@Secured("ROLE_ADMIN")
		@PostMapping("/discapacidades")
		public ResponseEntity<?> create(@Valid @RequestBody Discapacidad discapacidad, BindingResult result) {
			
			Discapacidad discapacidadNew = null;
			Map<String, Object> response = new HashMap<>();
			
			if(result.hasErrors()) {

				List<String> errors = result.getFieldErrors()
						.stream()
						.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
						.collect(Collectors.toList());
				
				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			
			try {
				discapacidadNew = discapacidadService.save(discapacidad);
			} catch(DataAccessException e) {
				response.put("mensaje", "Error al agregar la discapacidad en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("mensaje", "La discapacidad ha sido creado con éxito!");
			response.put("discapacidad", discapacidadNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		//@Secured("ROLE_ADMIN")
		@PutMapping("/discapacidades/{id}")
		public ResponseEntity<?> update(@Valid @RequestBody Discapacidad discapacidad, BindingResult result, @PathVariable Long id) {

			Discapacidad discapacidadActual = discapacidadService.findById(id);

			Discapacidad discapacidadUpdated = null;

			Map<String, Object> response = new HashMap<>();

			if(result.hasErrors()) {

				List<String> errors = result.getFieldErrors()
						.stream()
						.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
						.collect(Collectors.toList());
				
				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
			
			if (discapacidadActual == null) {
				response.put("mensaje", "Error: no se pudo editar, la discapacidad con el ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			try {
				discapacidadActual.setDescripcionDiscapacidad(discapacidad.getDescripcionDiscapacidad());
				discapacidadActual.setPorcetajeDiscapacidad(discapacidad.getPorcetajeDiscapacidad());
				discapacidadActual.setTipoDiscapacidad(discapacidad.getTipoDiscapacidad());
				

				discapacidadUpdated = discapacidadService.save(discapacidadActual);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar la discapacidad en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "La discapacidad ha sido actualizado con éxito!");
			response.put("discapacidad", discapacidadUpdated);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		
		//@Secured("ROLE_ADMIN")
		@DeleteMapping("/discapacidades/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			
			Map<String, Object> response = new HashMap<>();
			
			try {
				Discapacidad discapacidad = discapacidadService.findById(id);
				discapacidadService.delete(discapacidad.getIdDiscapacidad());
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al eliminar la discapacidad de la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("mensaje", "La discapacidad se ha eliminado con éxito!");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		
		

		
		//@PostMapping(value = "/discapacidades")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<?>guardarDiscapacidad(@RequestBody Discapacidad discapacidad){
			Map<String, Object> response = new HashMap<>();
			Discapacidad discapacidadNuevo=null;
			try {
		
				discapacidadNuevo=discapacidadService.save(discapacidad);		
			
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
				return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
					
			
			response.put("mensaje", "Registro Discapacidad ha sido creado con exito");
			response.put("discapacidad", discapacidadNuevo);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		
		
		
		
		//@PutMapping("/discapacidades/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<?> actualizarDiscapacidad(@RequestBody Discapacidad discapacidad,@PathVariable Long id) {
			
			Map<String, Object> response = new HashMap<>();
			
			Discapacidad discapacidadActual=discapacidadService.findById(id);
			Discapacidad discapacidadActualizado=null;
			
			if (discapacidadActual == null) {
				response.put("mensaje", "Error: no se pudo editar , la discapacidad con ID: "
						.concat(id.toString().concat("no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		
			
			try {
				
				discapacidadActual.setDescripcionDiscapacidad(discapacidad.getDescripcionDiscapacidad());
				discapacidadActual.setPorcetajeDiscapacidad(discapacidad.getPorcetajeDiscapacidad());
				discapacidadActual.setTipoDiscapacidad(discapacidad.getTipoDiscapacidad());
				discapacidadActual.setIdDiscapacidad(discapacidad.getIdDiscapacidad());
			
	        
				discapacidadActualizado=discapacidadService.actualizarDiscapacidad(discapacidadActual);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar en la base de datos");
				response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
				return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("mensaje", "La discapacidad se ha sido actualizado con exito");
			response.put("discapacidad", discapacidadActualizado);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	
	
}
