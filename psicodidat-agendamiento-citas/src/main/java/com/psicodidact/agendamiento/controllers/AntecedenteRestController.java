package com.psicodidact.agendamiento.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
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

import com.psicodidact.agendamiento.models.entity.Antecedente;
import com.psicodidact.agendamiento.services.IAntecedentesService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AntecedenteRestController {


	@Autowired
	private IAntecedentesService antecedenteService;
	
	@GetMapping("/antecedente")
	public List<Antecedente> index() {
		return antecedenteService.findAll();
	}
	
	
	@PostMapping(value = "/antecedente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarAntecedentes(@RequestBody Antecedente antededente){
		Map<String, Object> response = new HashMap<>();
		Antecedente antcedenteNuevo=null;
		try {
			
			antcedenteNuevo=antecedenteService.save(antededente);		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
				
		
		response.put("mensaje", "Registro Antecedente ha sido creado con exito");
		response.put("antecedente", antcedenteNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/antecedente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> actualizarAntecedentes(@RequestBody Antecedente antededente,@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Antecedente antecedentesActual=antecedenteService.findById(id);
		Antecedente antecedentesActualizado=null;
		
		if (antecedentesActual == null) {
			response.put("mensaje", "Error: no se pudo editar , antecedente con ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
			
		try {
			
			
					
			antecedentesActual.setEnfermedadAntecedente(antededente.getEnfermedadAntecedente());
			antecedentesActual.setEnfermedadMaterna(antededente.getEnfermedadMaterna());
			antecedentesActual.setEnfermedadPaterna(antededente.getEnfermedadPaterna());
			antecedentesActual.setEnfermedadRepresentante(antededente.getEnfermedadRepresentante());
			antecedentesActual.setIdAntecedente(antededente.getIdAntecedente());
			antecedentesActual.setAlergiaAntecedente(antededente.getAlergiaAntecedente());
			antecedentesActual.setMedicamentoAntecedente(antededente.getMedicamentoAntecedente());
			antecedentesActual.setSintomaAntecedente(antededente.getSintomaAntecedente());
			antecedentesActual.setTratamientoAntecedente(antededente.getTratamientoAntecedente());
        
			antecedentesActualizado=antecedenteService.actualizar(antecedentesActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Antecedentes ha sido actualizado con exito");
		response.put("antecedente", antecedentesActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
}