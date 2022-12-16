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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.services.ITipoDiscapacidadService;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoDiscapasidadRestController {


	@Autowired
	private ITipoDiscapacidadService tipoDiscapacidadService;
	

	@GetMapping("/tiposDiscapacidades")
	public List<TipoDiscapacidad> index() {
		return tipoDiscapacidadService.findAll();
	}
	
	
	@PostMapping(value = "/tiposDiscapacidades")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarTipoDiscapacidad(@RequestBody TipoDiscapacidad tipoDiscapacidad){
		Map<String, Object> response = new HashMap<>();
		TipoDiscapacidad tipoDiscapacidadNuevo=null;
		try {
		System.out.println("tipo discacpcidad "+tipoDiscapacidad);
		System.out.println("INGRESA AL INSERT----------------------------------------------------");
	
			tipoDiscapacidadNuevo=tipoDiscapacidadService.save(tipoDiscapacidad);		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
				
		
		response.put("mensaje", "Registro Discapacidad ha sido creado con exito");
		response.put("tipoDiscapacidad", tipoDiscapacidadNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/tiposDiscapacidades/{id_TipoDiscapacidad}")
	public ResponseEntity<?>  obtenerTipoDiscapacidadById( @PathVariable("id_TipoDiscapacidad") Long id_TipoDiscapacidad) {
		Map<String, Object> response = new HashMap<>();
		TipoDiscapacidad tipoDiscapacidadNuevo=null;
		try {
			tipoDiscapacidadNuevo=tipoDiscapacidadService.findById(id_TipoDiscapacidad);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (tipoDiscapacidadNuevo == null) {
			response.put("mensaje", "El representante ID ".concat(id_TipoDiscapacidad.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("se le responde "+tipoDiscapacidadNuevo);
		return new ResponseEntity<TipoDiscapacidad>(tipoDiscapacidadNuevo, HttpStatus.OK);
	} 
	
	
	
}
