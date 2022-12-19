package com.psicodidact.agendamiento.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Paciente;
import com.psicodidact.agendamiento.services.IActividadService;
import com.psicodidact.agendamiento.services.IPacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PacienteRestController {


	@Autowired
	private IPacienteService pacienteService;
	
	@GetMapping("/pacientes")
	public List<Paciente> index() {
		return pacienteService.findAll();
	}
	
	
	@PostMapping(value="/pacientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?>guardarPaciente(@RequestBody Paciente paciente ){
		
		Map<String, Object> response = new HashMap<>();
		Paciente pacienteNuevo=null;
		
		try {
			pacienteNuevo=pacienteService.save(paciente);
			
	} catch (DataAccessException  e) {
		  	System.out.println("error en el insert"+e.getMessage());
		response.put("mensaje", "Error al realizar el insert en la base de datos");
		response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
		return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El paciente ha sido creado con exito");
		response.put("paciente", pacienteNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	
	
	
	@GetMapping("/pacientes/{id_Paciente}")
	public ResponseEntity<?>  obtenerPacienteById( @PathVariable("id_Paciente") Long id_Paciente) {
		Map<String, Object> response = new HashMap<>();
		Paciente pacienteNuevo=null;
		try {
			pacienteNuevo=pacienteService.findById(id_Paciente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (pacienteNuevo == null) {
			response.put("mensaje", "El cliente ID ".concat(id_Paciente.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Paciente>(pacienteNuevo, HttpStatus.OK);
	} 
	
	
	@DeleteMapping("/pacientes/{id_Paciente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> eliminarPaciente(@PathVariable("id_Paciente") Long id_Representante) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			pacienteService.delete(id_Representante);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar  el paciente en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/pacientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente,@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Paciente pacienteActual=pacienteService.findById(id);
		Paciente pacienteActualizado=null;
		
		if (pacienteActual == null) {
			response.put("mensaje", "Error: no se pudo editar , el paciente ID: "
					.concat(id.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	
		
		try {
			
			
			pacienteActual.setRepresentante(paciente.getRepresentante());
			pacienteActual.setTipoSangre(paciente.getTipoSangre());
			pacienteActual.setDiscapacidad(paciente.getDiscapacidad());
			pacienteActual.setEstadoCivil(paciente.getEstadoCivil());
			pacienteActual.setGenero(paciente.getGenero());
			pacienteActual.setTrabajo(paciente.getTrabajo());
			pacienteActual.setProfesion(paciente.getProfesion());
			pacienteActual.setUnidadEducativa(paciente.getUnidadEducativa());
			pacienteActual.setNivelEducacionParalelo(paciente.getNivelEducacionParalelo());
			pacienteActual.setAntecedente(paciente.getAntecedente());
			pacienteActual.setIdentificacionPaciente(paciente.getIdentificacionPaciente());
			pacienteActual.setNombresPaciente(paciente.getNombresPaciente());
			pacienteActual.setApellidoPaternoPaciente(paciente.getApellidoPaternoPaciente());
			pacienteActual.setFechaNacimientoPaciente(paciente.getFechaNacimientoPaciente());
			pacienteActual.setCelularPaciente(paciente.getCelularPaciente());
			pacienteActual.setDireccionDomicilio(paciente.getDireccionDomicilio());
			pacienteActual.setTelefonoPaciente(paciente.getTelefonoPaciente());
			pacienteActual.setCorreoElectronicoPaciente(paciente.getCorreoElectronicoPaciente());
			pacienteActual.setApellidoMaternoPaciente(paciente.getApellidoMaternoPaciente());
			pacienteActual.setEstadoPaciente(paciente.getEstadoPaciente());
			
        
			pacienteActualizado=pacienteService.actualizar(pacienteActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El paciente ha sido actualizado con exito");
		response.put("paciente", pacienteActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/pacientes/cedula/{cedula_Paciente}")
	public ResponseEntity<?>  obtenerPacienteByCedula( @PathVariable("cedula_Paciente") String cedula_Paciente) {
		Map<String, Object> response = new HashMap<>();
		Paciente pacienteNuevo=null;
		try {
			pacienteNuevo=pacienteService.buscarPorCedulaPaciente(cedula_Paciente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (pacienteNuevo == null) {
			response.put("mensaje", "El paciente con cedula ".concat(cedula_Paciente.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Paciente>(pacienteNuevo, HttpStatus.OK);
	} 
	
	
	@GetMapping("/pacientes/apellido/{apellido_Paciente}")
	public ResponseEntity<?>  obtenerPacienteByApellido( @PathVariable("apellido_Paciente") String apellido_Paciente) {
		Map<String, Object> response = new HashMap<>();
		List<Paciente> pacienteNuevo=null;
		try {
			pacienteNuevo=pacienteService.buscarPacienteByApellidoPaterno(apellido_Paciente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
			return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (pacienteNuevo.size()==0) {
			response.put("mensaje", "El paciente con apellido ".concat(apellido_Paciente.toString().concat("no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Paciente>>(pacienteNuevo, HttpStatus.OK);
	} 
	
	
	
}