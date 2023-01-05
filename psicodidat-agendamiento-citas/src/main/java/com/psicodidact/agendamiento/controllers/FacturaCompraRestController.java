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

import com.psicodidact.agendamiento.models.entity.Especialidad;
import com.psicodidact.agendamiento.models.entity.FacturaCompra;
import com.psicodidact.agendamiento.models.entity.FacturaDetalleCompra;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.Paciente;
import com.psicodidact.agendamiento.models.entity.PreciosProducto;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.Servicio;
import com.psicodidact.agendamiento.models.entity.ServicioCompra;
import com.psicodidact.agendamiento.services.IEspecialidadService;
import com.psicodidact.agendamiento.services.IFacturaCompraService;
import com.psicodidact.agendamiento.services.IFacturaDetalleCompraService;
import com.psicodidact.agendamiento.services.IPacienteService;
import com.psicodidact.agendamiento.services.IPreciosProductoService;
import com.psicodidact.agendamiento.services.IServicioCompraService;
import com.psicodidact.agendamiento.services.IServicioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class FacturaCompraRestController {
	
	@Autowired
	private IEspecialidadService especialidadService;


	@Autowired
	private IServicioService productoService;
	
	@Autowired
	private IPreciosProductoService precioService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	
	@Autowired
	private IFacturaCompraService facturaService;
	
	@Autowired
	private IFacturaDetalleCompraService detalleService;
	

	
	@GetMapping("/facturas/facturaCompra")
	public List<FacturaCompra> findAll() {
		return facturaService.findAll();
	}
	
	@GetMapping("/facturas/facturaDetalleCompra")
	public List<FacturaDetalleCompra> findAllDetalle() {
		return detalleService.findAll();
	}
	
	@GetMapping("/facturas/precioProducto")
	public List<PreciosProducto> findAllPrecioProducto() {
		return precioService.findAll();
	}
	
	@GetMapping("/facturas/facturaCompra/{id}")
	public ResponseEntity<?> findAById(Long id) {
		
		FacturaCompra factura = null;
		Map<String, Object> response = new HashMap<>();

		try {
			factura = facturaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (factura == null) {
			response.put("mensaje",
					"La factura con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<FacturaCompra>(factura, HttpStatus.OK);
	}
	
	
	@GetMapping("/facturas/filtrar-productos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Servicio> filtrarProductos(@PathVariable String term){
		return productoService.findBydescripcionServicioContainingIgnoreCase(term);
	}
	

	
	@GetMapping("/facturas/especialidad")
	public List<Especialidad> findAllEspecialidad() {
		return this.especialidadService.findAll();
	}
	
	@GetMapping("/facturas/pacientes/{identificacion}")
	@ResponseStatus(HttpStatus.OK)
	public List<Paciente> filtrarPacientesIdentificacion(@PathVariable("identificacion") String term){
		return  pacienteService.findByIdentificacionPacienteContainingIgnoreCase(term);
	}
	
	@GetMapping("/facturas/pacientes/{apellido}")
	@ResponseStatus(HttpStatus.OK)
	public List<Paciente> filtrarPacientesApellido(@PathVariable("apellido") String term){
		return pacienteService.findByApellidoPaternoPacienteContainingIgnoreCase(term);
	}
	
	@GetMapping("/facturas/producto")
	public List<Servicio> findAllProducto() {
		return this.productoService.findAll();
	}
	

	//crear el encabezado la factura
	// @Secured("ROLE_ADMIN")
		@PostMapping("/facturas/facturaCompra")
		public ResponseEntity<?> create(@Valid @RequestBody FacturaCompra factura, BindingResult result) {

			FacturaCompra facturaNew = null;
			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {

				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		
	   
			try {
				facturaNew = facturaService.save(factura);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al agregar la factura en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "La factura ha sido creado con éxito!");
			response.put("factura", facturaNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}

		
		//crear el encabezado la factura
		// @Secured("ROLE_ADMIN")
			@PostMapping("/facturas/detalle/facturaCompra")
			public ResponseEntity<?> createDetalle(@Valid @RequestBody FacturaDetalleCompra facturaDetalle, BindingResult result) {

				FacturaDetalleCompra facturaDetalleNew = null;
				Map<String, Object> response = new HashMap<>();

				if (result.hasErrors()) {

					List<String> errors = result.getFieldErrors().stream()
							.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
							.collect(Collectors.toList());

					response.put("errors", errors);
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			
		   
				try {
					facturaDetalleNew = detalleService.save(facturaDetalle);
				} catch (DataAccessException e) {
					response.put("mensaje", "Error al agregar al detalle de la factura en la base de datos");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}

				response.put("mensaje", "El detalle de la factura ha sido creado con éxito!");
				response.put("factura", facturaDetalleNew);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
			}

			
		
		@PutMapping("/facturas/{id}")
		public ResponseEntity<?> update(@Valid @RequestBody FacturaCompra factura, BindingResult result,
				@PathVariable Long id) {

			FacturaCompra facturaActual = facturaService.findById(id);

			FacturaCompra facturaUpdated = null;

			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {

				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			if (facturaActual == null) {
				response.put("mensaje", "Error: no se pudo editar, el profesional con el ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
	        
			try {
				facturaActual.setPaciente(factura.getPaciente());
				facturaActual.setSucursal(factura.getSucursal());
				facturaActual.setFechaCreacionFacturacion(factura.getFechaCreacionFacturacion());
				facturaActual.setDescripcionFacturaCompra(factura.getDescripcionFacturaCompra());
				//facturaActual.setFacturaDetalles(factura.getDescripcionFacturaCompra());


				facturaUpdated = facturaService.save(facturaActual);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar la factura en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "la factura ha sido actualizado con éxito!");
			response.put("factura", facturaUpdated);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
	
	
	
}
