package com.psicodidact.agendamiento.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.psicodidact.agendamiento.auth.JwtUtils;
import com.psicodidact.agendamiento.entidades.autoridades.JwtRequest;
import com.psicodidact.agendamiento.entidades.autoridades.JwtResponse;
import com.psicodidact.agendamiento.excepciones.UsuarioNotFoundException;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.services.impl.UserDetailsServiceImpl;




@RestController
@CrossOrigin("*")
public class AuthenticationController {

	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
       System.out.println("AuthenticationController generarToken");
    	try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsuarioNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }

    	//carga los detalles del usuario lo convierte
    	//se guada las autoridades, contrasena , usuario
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
 //   está pasando el UsernamePasswordAuthenticationToken al valor predeterminado AuthenticationProvider, 
    //que utilizará el userDetailsService para obtener el usuario según el nombre de usuario y comparar la
    //contraseña de ese usuario con la del token de autenticación.

    private void autenticar(String username,String password) throws Exception {
    	  System.out.println("autenticar");
    	try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }
	
}
