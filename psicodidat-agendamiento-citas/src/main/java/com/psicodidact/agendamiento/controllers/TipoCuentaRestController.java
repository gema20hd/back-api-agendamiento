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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.Trabajo;
import com.psicodidact.agendamiento.services.ITipoCuentaService;
import com.psicodidact.agendamiento.services.ITrabajoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoCuentaRestController {

	@Autowired
	private ITipoCuentaService tipoCuentaService;
	
	@GetMapping("/TipoCuenta")
	public List<TipoCuenta> index() {
		return tipoCuentaService.findAll();
	}
	
	@GetMapping("/tiposCuenta/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		TipoCuenta tipoCuenta = null;
		Map<String, Object> response = new HashMap<>();

		try {
			tipoCuenta = tipoCuentaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (tipoCuenta == null) {
			response.put("mensaje",
					"El tipo de cuenta con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TipoCuenta>(tipoCuenta, HttpStatus.OK);
	}

}