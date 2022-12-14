package com.psicodidact.agendamiento.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuariosRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> findAllUsers() {
		return usuarioService.findAll();
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if(usuarioService.findByUsername(usuario.getUsername())!=null) {
        	response.put("validarUsuarioRepetida", "Error: no se pudo crear, el usuario con el username: "
					.concat(usuario.getUsername().concat(" ya existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
		try {
			List<Rol> roles= new ArrayList<Rol>();
			roles.add(new Rol(1L,"ROLE_USER"));
			
			usuario.setRoles(roles);
			usuarioNew = usuarioService.save(usuario);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al agregar al usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			
		}
		try {
			usuarioService.insertRolesDeUsuario(usuarioNew.getIdUsuario(), 1L);
			
		}catch(DataAccessException e) {
			
			
			response.put("mensaje", "El usuario ha sido creado con ??xito!");
			response.put("usuario", usuarioNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		response.put("mensaje", "El usuario ha sido creado con ??xito!");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
