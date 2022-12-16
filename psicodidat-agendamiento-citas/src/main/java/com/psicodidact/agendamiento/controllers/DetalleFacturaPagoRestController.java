package com.psicodidact.agendamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.DetalleFacturaPago;
import com.psicodidact.agendamiento.services.IDetalleFacturaPagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DetalleFacturaPagoRestController {
	
	@Autowired
	private IDetalleFacturaPagoService detalleFacturaPagoService;

	@GetMapping("/detalleFcaturaPago")
	public List<DetalleFacturaPago> index() {
		return detalleFacturaPagoService.findAll();
	}
}
