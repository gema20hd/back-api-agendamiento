package com.psicodidact.agendamiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.services.IUnidadEducativaService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UnidadEducativaRestController {


	@Autowired
	private IUnidadEducativaService unidadEducativaService;
	
	// este metodo obtiene todas las unidades educativas de la base de datos
	@GetMapping("/unidadesEducativas")
	public List<UnidadEducativa> index() {
		return unidadEducativaService.findAll();
	}
	
	// este metodo obtiene una unidad educativa especifica de la base de datos
	@GetMapping("/unidadesEducativas/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		UnidadEducativa unidadEducativa = null;
		Map<String, Object> response = new HashMap();
		
		try {
			unidadEducativa = unidadEducativaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(unidadEducativa == null) {
			response.put("mensaje", "La unidad educativa con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UnidadEducativa>(unidadEducativa, HttpStatus.OK);
	}
	
	
	
	// este metodo permite crear una unidad educativa
	//@Secured("ROLE_ADMIN")
	@PostMapping("/unidadesEducativas")
	public ResponseEntity<?> create(@Valid @RequestBody UnidadEducativa unidadEducativa, BindingResult result) {
		
		UnidadEducativa unidadEducativaNew = null;
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
			unidadEducativaNew = unidadEducativaService.save(unidadEducativa);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al agregar la unidad educativa en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La unidad educativa ha sido creado con éxito!");
		response.put("unidadEducativa", unidadEducativaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	// este metodo permite editar una unidad educativa
	//@Secured("ROLE_ADMIN")
	@PutMapping("/unidadesEducativas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody UnidadEducativa unidadEducativa, BindingResult result, @PathVariable Long id) {

		UnidadEducativa unidadEducativaActual = unidadEducativaService.findById(id);

		UnidadEducativa unidadEducativaUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (unidadEducativaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la unidad educativa con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			unidadEducativaActual.setNombreUnidadEducativa(unidadEducativa.getNombreUnidadEducativa());
			unidadEducativaActual.setDireccionUnidadEducativa(unidadEducativa.getDireccionUnidadEducativa());
			unidadEducativaActual.setCodigoInstitucion(unidadEducativa.getCodigoInstitucion());
			unidadEducativaActual.setIdUnidadEducativa(unidadEducativa.getIdUnidadEducativa());
			
			

			unidadEducativaUpdated = unidadEducativaService.save(unidadEducativaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la unidad educativa en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La unidad educativa ha sido actualizado con éxito!");
		response.put("unidadEducativa", unidadEducativaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/unidad/nombre/{nombre}") 
	@ResponseStatus(HttpStatus.OK)
	public List<UnidadEducativa> findByNombreUnidadEducativaContainingIgnoreCase(@PathVariable("nombre") String term) {
		return unidadEducativaService.findByNombreUnidadEducativaContainingIgnoreCase(term);
	}
	
}