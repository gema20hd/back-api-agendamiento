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
import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.services.IActividadService;
import com.psicodidact.agendamiento.services.IBancoService;
import com.psicodidact.agendamiento.services.ICuentaService;
import com.psicodidact.agendamiento.services.ITipoCuentaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CuentaRestController {

	@Autowired
	private ICuentaService cuentaService;

	@GetMapping("/cuentas")
	public List<Cuenta> findAll() {
		return cuentaService.findAll();
	}

	@GetMapping("/cuentas/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Cuenta cuenta = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cuenta = cuentaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cuenta == null) {
			response.put("mensaje",
					"La cuenta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
	}

	@PostMapping("/cuentas")
	public ResponseEntity<?> create(@Valid @RequestBody Cuenta cuenta, BindingResult result) {

		Cuenta cuentaNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			cuentaNew = cuentaService.save(cuenta);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al agregar la cuenta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La cuenta ha sido creado con éxito!");
		response.put("cuenta", cuentaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// @Secured("ROLE_ADMIN")
	@PutMapping("/cuentas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cuenta cuenta, BindingResult result, @PathVariable Long id) {

		Cuenta cuentaActual = cuentaService.findById(id);

		Cuenta cuentaUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (cuentaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la curnta con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			cuentaActual.setNumeroCuenta(cuenta.getNumeroCuenta());
			cuentaActual.setTipoCuenta(cuenta.getTipoCuenta());
			cuentaActual.setBanco(cuenta.getBanco());

			cuentaUpdated = cuentaService.save(cuentaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la cuenta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La cuenta ha sido actualizado con éxito!");
		response.put("cuenta", cuentaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// @Secured("ROLE_ADMIN")
	@DeleteMapping("/cuentas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			Cuenta cuentas = cuentaService.findById(id);
			cuentaService.delete(cuentas.getIdCuenta());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la cuenta de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La cuenta se ha eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/cuentas/bancos")
	public List<Banco> findAllBank() {
		return cuentaService.findAllBank();
	}

	@GetMapping("/cuentas/tipoCuentas")
	public List<TipoCuenta> findAllTypeCount() {
		return cuentaService.findAllAccounType();
	}

	@GetMapping("/cuentas/bancos/{id}")
	public ResponseEntity<?> findByIdBank(@PathVariable() Long id) {

		Banco banco = null;
		Map<String, Object> response = new HashMap<>();

		try {
			banco = cuentaService.findByBank(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (banco == null) {
			response.put("mensaje",
					"La cuenta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Banco>(banco, HttpStatus.OK);
	}

	@GetMapping("cuentas/bancos/filtro/{descripcion}")
	@ResponseStatus(HttpStatus.OK)
	public List<Banco> findByDescripcionBanco(@PathVariable("descripcion") String descripcionBanco) {
		return cuentaService.findByDescripcionBancoContainingIgnoreCase(descripcionBanco);
	}

}