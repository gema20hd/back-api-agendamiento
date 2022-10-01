package com.psicodidact.agendamiento.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
public class SpringSecurityConfig {

	@Autowired
	private UserDetailsService usuarioService;
	
	

}
