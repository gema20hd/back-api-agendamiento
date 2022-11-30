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
import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.services.IBancoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class BancoRestController {


	@Autowired
	private IBancoService bancoService;
	
	@GetMapping("/bancos")
	public List<Banco> findAll() {
		return bancoService.findAll();
	}
	
	@GetMapping("/bancos/{id}")
	public ResponseEntity<?> findByIdBank(@PathVariable Long id) {
		
		Banco banco = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			banco = bancoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(banco == null) {
			response.put("mensaje", "La cuenta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Banco>(banco, HttpStatus.OK);
	}
	
	
	
	//@Secured("ROLE_ADMIN")
	@PostMapping("/bancos")
	public ResponseEntity<?> create(@Valid @RequestBody Banco banco, BindingResult result) {
		
		Banco bancoNew = null;
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
			bancoNew = bancoService.save(banco);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al agregar la cuenta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El banco ha sido creado con éxito!");
		response.put("cuenta", bancoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//@Secured("ROLE_ADMIN")
	@PutMapping("/bancos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Banco banco, BindingResult result, @PathVariable Long id) {

		Banco bancoActual = bancoService.findById(id);

		Banco bancoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (bancoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la curnta con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			bancoActual.setDescripcionBanco(banco.getDescripcionBanco());
			
			

			bancoUpdated = bancoService.save(bancoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la cuenta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El banco ha sido actualizado con éxito!");
		response.put("banco", bancoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	//@Secured("ROLE_ADMIN")
	@DeleteMapping("/bancos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			Banco banco = bancoService.findById(id);
			bancoService.delete(banco.getIdBanco());
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la cuenta de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El banco se ha eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	
}