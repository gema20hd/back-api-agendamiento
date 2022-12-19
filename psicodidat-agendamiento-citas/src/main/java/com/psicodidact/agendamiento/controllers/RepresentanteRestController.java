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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.Representante;
import com.psicodidact.agendamiento.services.IProfesionalService;
import com.psicodidact.agendamiento.services.IRepresentanteService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RepresentanteRestController {


	@Autowired
	private IRepresentanteService representanteService;
	
	
	
	@GetMapping("/representantes")
	public ResponseEntity<?> listarRepresentantes() {
		System.out.println("ingresa");
		return ResponseEntity.ok(representanteService.findAll());
	}
	
	
	
	
	
	@PostMapping(value = "/representantes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarRepresentante(@RequestBody Representante representante){
		Map<String, Object> response = new HashMap<>();
		Representante representanteNuevo=null;
		try {
	
			 representanteNuevo=representanteService.save(representante);		
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
				
		
		response.put("mensaje", "El representante ha sido creado con exito");
		response.put("representante", representanteNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	@GetMapping("/representantes/{id_Representante}")
	public ResponseEntity<?>  obtenerRepresentanteById( @PathVariable("id_Representante") Long id_Representante) {
		Map<String, Object> response = new HashMap<>();
		Representante representanteNuevo=null;
		try {
			representanteNuevo=representanteService.findById(id_Representante);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (representanteNuevo == null) {
			response.put("mensaje", "El representante ID ".concat(id_Representante.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("se le responde "+representanteNuevo);
		return new ResponseEntity<Representante>(representanteNuevo, HttpStatus.OK);
	} 
	
	
	
	
	
	
	@DeleteMapping("/representantes/{id_Representante}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> eliminarRepresentante(@PathVariable("id_Representante") Long id_Representante) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			representanteService.eliminar(id_Representante);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar  el representante en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	@PutMapping("/representantes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> actualizarRepresentante(@RequestBody Representante representante,@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		Representante representanteActual=representanteService.findById(id);;
		Representante representanteActualizado=null;
		
		if (representanteActual == null) {
			response.put("mensaje", "Error: no se pudo editar , el representante ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		
		try {
		
			representanteActual.setTipoSangre(representante.getTipoSangre());
			representanteActual.setDiscapacidad(representante.getDiscapacidad());
			representanteActual.setEstadoCivil(representante.getEstadoCivil());
			representanteActual.setGenero(representante.getGenero());
			representanteActual.setTrabajo(representante.getTrabajo());
			representanteActual.setProfesion(representante.getProfesion());
			representanteActual.setIdentificacionRepresentante(representante.getIdentificacionRepresentante());
			representanteActual.setApellidoPaternoRepresentante(representante.getApellidoPaternoRepresentante());
			representanteActual.setApellidoMaternoRepresentante(representante.getApellidoMaternoRepresentante());
			representanteActual.setNombresRepresentante(representante.getNombresRepresentante());
			representanteActual.setFechaNacimientoRepresentante(representante.getFechaNacimientoRepresentante());
			representanteActual.setCorreoElectronicoRepresentante(representante.getCorreoElectronicoRepresentante());
			representanteActual.setCelularRepresentante(representante.getCelularRepresentante());
			representanteActual.setTelefonoEmergenciaRepresentante(representante.getTelefonoEmergenciaRepresentante());
			representanteActual.setParentescoRepresentante(representante.getParentescoRepresentante());
			representanteActual.setDireccionDomicilioRepresentan(representante.getDireccionDomicilioRepresentan());
			representanteActual.setEstadoCivil(representante.getEstadoCivil());
			
			representanteActualizado=representanteService.actualizar(representanteActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Representante ha sido creado con exito");
		response.put("representante", representanteActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/representantes/cedula/{cedula_Representante}")
	public ResponseEntity<?>  obtenerRepresentanteByCedula( @PathVariable("cedula_Representante") String cedula_Representante) {
		Map<String, Object> response = new HashMap<>();
		Representante representanteNuevo=null;
		try {
			representanteNuevo=representanteService.buscarPorCedulaRepresentante(cedula_Representante);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (representanteNuevo == null) {
			response.put("mensaje", "El representante con cedula ".concat(cedula_Representante.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Representante>(representanteNuevo, HttpStatus.OK);
	} 
	
	
}
