package com.psicodidact.agendamiento.controllers;

import java.util.ArrayList;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoSangre;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IProfesionProfesionalRepository;
import com.psicodidact.agendamiento.services.IBancoService;
import com.psicodidact.agendamiento.services.ICuentaService;
import com.psicodidact.agendamiento.services.IDiscapacidadService;
import com.psicodidact.agendamiento.services.IEstadoCivilService;
import com.psicodidact.agendamiento.services.IGeneroService;
import com.psicodidact.agendamiento.services.IProfesionProfesionalService;
import com.psicodidact.agendamiento.services.IProfesionService;
import com.psicodidact.agendamiento.services.IProfesionalService;
import com.psicodidact.agendamiento.services.IRolService;
import com.psicodidact.agendamiento.services.ITipoCuentaService;
import com.psicodidact.agendamiento.services.ITipoSangreService;
import com.psicodidact.agendamiento.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProfesionalRestController {

	@Autowired
	private IProfesionalService profesionalService;
	@Autowired
	private ICuentaService cuentaService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ITipoCuentaService tipoCuentaService;
	@Autowired
	private IRolService rolesService;
	@Autowired
	private IBancoService bancoService;
	@Autowired
	private IEstadoCivilService estadoCivilService;
	@Autowired
	private IGeneroService generoService;
	@Autowired
	private ITipoSangreService tipoSangreService;
	@Autowired
	private IDiscapacidadService discapacidadService;
	@Autowired
	private IProfesionProfesionalService profesionService;
	
	// @Secured({"ROLE_ADMIN"})
	@GetMapping("/profesionales")
	public List<Profesional> index() {
		return profesionalService.findAll();
	}

	// @Secured({"ROLE_ADMIN"})
	@GetMapping("/profesionales/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Profesional profesional = null;
		Map<String, Object> response = new HashMap<>();

		try {
			profesional = profesionalService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (profesional == null) {
			response.put("mensaje",
					"El profesional con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Profesional>(profesional, HttpStatus.OK);
	}

	// @Secured({"ROLE_ADMIN"})
	@GetMapping("/profesionales/identificacion/{dni}")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesional> findByI(@PathVariable("dni") String identificacion) {
		return profesionalService.findByIdentificacionProfesionalContainingIgnoreCase(identificacion);
	}
	/*public ResponseEntity<?> findByIdentification(@PathVariable("dni") String identificacion) {
		Profesional profesional = null;
		Map<String, Object> response = new HashMap<>();

		try {
			profesional = profesionalService.findI(identificacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (profesional == null) {
			response.put("mensaje",
					"El profesional con el ID: ".concat(identificacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Profesional>(profesional, HttpStatus.OK);
	}
	*/
	

	// @Secured({"ROLE_ADMIN"})
	@GetMapping("/profesionales/apellido/paterno/{lastName}")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesional> findByLastName(@PathVariable("lastName") String apellidoPaterno) {
		return profesionalService.findByApellidoPaternoProfesionalContainingIgnoreCase(apellidoPaterno);
	}

	// @Secured({"ROLE_ADMIN"})
	@GetMapping("/profesionales/apellido/materno/{lastName2}")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesional> findByMotherLastName(@PathVariable("lastName2") String apellidoMaterno) {
		return profesionalService.findByApellidoMaternoProfesionalContainingIgnoreCase(apellidoMaterno);
	}

	// @Secured("ROLE_ADMIN")
	@GetMapping("/profesionales/genero")
	public List<Genero> findAllGender() {
		return this.profesionalService.findAllGender();
	}

	// @Secured("ROLE_ADMIN")
	@GetMapping("/profesionales/estadoCivil")
	public List<EstadoCivil> findAllMaritalStatus() {
		return this.profesionalService.findAllMaritalStatus();
	}

	// @Secured("ROLE_ADMIN")
	@GetMapping("/profesionales/discapacidad")
	public List<Discapacidad> findAllDisability() {
		return this.profesionalService.findAllDisability();
	}

	@GetMapping("/profesionales/tipoDiscapacidad")
	public List<TipoDiscapacidad> findAllTypeDisability() {
		return this.profesionalService.findAllTypeDisability();
	}

	// @Secured("ROLE_ADMIN")
	@GetMapping("/profesionales/tipoSangre")
	public List<TipoSangre> findAllTypeBlood() {
		return this.profesionalService.findAllTypeBlood();
	}

	// @Secured("ROLE_ADMIN")
	@GetMapping("/profesionales/profesionProfesional")
	public List<ProfesionProfesional> findAllProfessionProfessional() {
		return this.profesionalService.findAllProfessionProfessional();
	}

	// @Secured("ROLE_ADMIN")
	@PostMapping("/profesionales")
	public ResponseEntity<?> create(@Valid @RequestBody Profesional profesional, BindingResult result) {

		Profesional profesionalNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			profesionalNew = profesionalService.save(profesional);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al agregar al profesional en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El profesional ha sido creado con éxito!");
		response.put("profesional", profesionalNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// @Secured("ROLE_ADMIN")
	@PutMapping("/profesionales/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Profesional profesional, BindingResult result,
			@PathVariable Long id) {

		Profesional profesionalActual = profesionalService.findById(id);

		Profesional profesionalUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (profesionalActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el profesional con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			profesionalActual.setIdentificacionProfesional(profesional.getIdentificacionProfesional());
			profesionalActual.setNombresProfesional(profesional.getNombresProfesional());
			profesionalActual.setApellidoPaternoProfesional(profesional.getApellidoPaternoProfesional());
			profesionalActual.setApellidoMaternoProfesional(profesional.getApellidoMaternoProfesional());
			profesionalActual.setFechaNacimientoProfesional(profesional.getFechaNacimientoProfesional());
			profesionalActual.setGenero(profesional.getGenero());
			profesionalActual.setCorreoElectronicoProfesional(profesional.getCorreoElectronicoProfesional());
			profesionalActual.setCelularProfesional(profesional.getCelularProfesional());
			profesionalActual.setTelefonoEmergenciaProfesional(profesional.getTelefonoEmergenciaProfesional());
			profesionalActual.setProfesionProfesional(profesional.getProfesionProfesional());
			profesionalActual.setTituloCuartoNivelProfesional(profesional.getTituloCuartoNivelProfesional());
			profesionalActual.setDireccionDomicilioProfesional(profesional.getDireccionDomicilioProfesional());
			profesionalActual.setDiscapacidad(profesional.getDiscapacidad());
			profesionalActual.setTipoSangre(profesional.getTipoSangre());
			profesionalActual.setEstadoCivil(profesional.getEstadoCivil());
			profesionalActual.setEstadoProfesional(profesional.getEstadoProfesional());
			profesionalActual.setHojaVida(profesional.getHojaVida());
			profesionalActual.setCuenta(profesional.getCuenta());
			// profesionalActual.setTipoCuenta(profesional.getCuenta().getTipoCuenta());
			// profesionalActual.setBanco(profesional.getCuenta().getBanco());
			// profesionalActual.setTipoDiscapacidad(profesional.getTipoDiscapacidad());

			profesionalUpdated = profesionalService.save(profesionalActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el profesional en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El profesional ha sido actualizado con éxito!");
		response.put("profesional", profesionalUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// @Secured("ROLE_ADMIN")
	@DeleteMapping("/profesionales/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			Profesional profesional = profesionalService.findById(id);
			profesionalService.delete(profesional.getIdProfesional());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el profesional de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El profesional se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping(value="/profesionales/dependiente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createDependientesProfesional(@Valid @RequestBody Map<String, Object> mapProfesional) {

		Profesional profesionalNew = null;
		Usuario usuarioNew = null;
		Cuenta cuentaNew = null;
		TipoCuenta tipoCuentaNew = null;
		
		Map<String, Object> response = new HashMap<>();

		try {
			
			Profesional profesional = new Profesional();
			Usuario usuario = new Usuario();
			Cuenta cuenta = new Cuenta();
			TipoCuenta tipoCuenta = new TipoCuenta();
			
			profesional.setIdentificacionProfesional(mapProfesional.get("identificacionProfesional").toString());
			profesional.setNombresProfesional(mapProfesional.get("nombresProfesional").toString());
			profesional.setApellidoPaternoProfesional(mapProfesional.get("apellidoPaternoProfesional").toString());
			profesional.setApellidoMaternoProfesional(mapProfesional.get("apellidoMaternoProfesional").toString());
			profesional.setFechaNacimientoProfesional(mapProfesional.get("fechaNacimientoProfesional").toString());
			profesional.setCelularProfesional(mapProfesional.get("celularProfesional").toString());
			profesional.setTelefonoEmergenciaProfesional(mapProfesional.get("telefonoEmergenciaProfesional").toString());
			profesional.setDireccionDomicilioProfesional(mapProfesional.get("direccionDomicilioProfesional").toString());
			profesional.setCorreoElectronicoProfesional(mapProfesional.get("correoElectronicoProfesional").toString());
			profesional.setHojaVida(mapProfesional.get("hojaVida").toString());
			profesional.setNivelEducacion(mapProfesional.get("nivelEducacion").toString());
			profesional.setTituloCuartoNivelProfesional(mapProfesional.get("tituloCuartoNivelProfesional").toString());
			profesional.setDiscapacidad(discapacidadService.findById(Long.parseLong(mapProfesional.get("idDiscapacidad").toString())));
			profesional.setTipoSangre(tipoSangreService.findById(Long.parseLong(mapProfesional.get("idTipoSangre").toString())));
			profesional.setProfesionProfesional(profesionService.findById(Long.parseLong(mapProfesional.get("idProfesionProfesional").toString())));
			profesional.setEstadoCivil(estadoCivilService.findById(Long.parseLong(mapProfesional.get("idEstadoCivil").toString())));
			profesional.setGenero(generoService.findById(Long.parseLong(mapProfesional.get("idGenero").toString())));
			profesional.setEstadoProfesional(true);
			cuenta.setNumeroCuenta(mapProfesional.get("numero de cuenta").toString());
			cuenta.setTipoCuenta(tipoCuentaService.findById(Long.parseLong(mapProfesional.get("idTipoCuenta").toString())));//error parsear tipo de cuenta
			cuenta.setBanco(bancoService.findById(Long.parseLong(mapProfesional.get("idBanco").toString())));//error al parsear Banco
			cuentaNew = cuentaService.save(cuenta); 
			profesional.setCuenta(cuentaNew);
			profesionalNew = profesionalService.save(profesional);
			
			usuario.setPassword(mapProfesional.get("password").toString());
			List<Rol> nuevaLista = new ArrayList<>();

			nuevaLista.add(rolesService.findById(Long.parseLong(mapProfesional.get("idRol").toString())));

			usuario.setRoles(nuevaLista);
			usuario.setUsername(mapProfesional.get("numero de cuenta").toString());
			usuario.setEnabled(true);
			usuario.setProfesional(profesionalNew);
			usuarioNew = usuarioService.save(usuario);
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al agregar al usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("profesional", profesionalNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
}
