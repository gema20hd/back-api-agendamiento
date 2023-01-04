package com.psicodidact.agendamiento.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		/*
		.antMatchers(HttpMethod.GET, "/api/profesionales").hasAnyRole("ROLE_ADMIN","ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/{id}").hasAnyRole("ROLE_ADMIN")
		.antMatchers(HttpMethod.GET, "/profesionales/apellido/paterno/{lastName}").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/profesionales/apellido/materno/madre/{lastName2}").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/profesional/identificacion/{dni}").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.POST, "api/profesionales").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.PUT, "api/profesionales/{id}").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.DELETE, "api/profesionales/{id}").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/genero").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/estadoCivil").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/discapacidad").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/tipoSangre").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
		.antMatchers(HttpMethod.GET, "/api/profesional/profesionProfesiol").permitAll()
		*/
		.antMatchers(HttpMethod.GET, "/api/profesionales").permitAll()
		.antMatchers(HttpMethod.GET, "/api/profesional/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/profesionales/apellido/paterno/{lastName}").permitAll()
		.antMatchers(HttpMethod.GET, "/profesionales/apellido/materno/madre/{lastName2}").permitAll()
		.antMatchers(HttpMethod.GET, "/profesional/identificacion/{dni}").permitAll()
		.antMatchers(HttpMethod.POST, "api/profesionales").permitAll()
		.antMatchers(HttpMethod.PUT, "api/profesionales/{id}").permitAll()
		.antMatchers(HttpMethod.DELETE, "api/profesionales/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/profesional/genero").permitAll()
		.antMatchers(HttpMethod.POST, "api/cuentas").permitAll()
		.antMatchers(HttpMethod.POST, "api/usuarios").permitAll()
		
		.antMatchers(HttpMethod.GET, "/api/profesional/estadoCivil").permitAll()
		.antMatchers(HttpMethod.GET, "/api/profesional/discapacidad").permitAll()
		.antMatchers(HttpMethod.GET, "/api/profesional/tipoSangre").permitAll()
		.antMatchers(HttpMethod.GET, "/api/profesional/profesionProfesional").permitAll()

		
		.antMatchers(HttpMethod.GET, "/api/pacientes").permitAll()
		.antMatchers(HttpMethod.POST,"/api/pacientes").permitAll()
		.antMatchers(HttpMethod.GET, "/api/pacientes/{id_Paciente}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/pacientes/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/pacientes/cedula/{cedula_Paciente}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/pacientes/apellido/{apellido_Paciente}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/pacientes/identificacion/{dni}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/pacientes/apellido/paterno/{lastName}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/representantes").permitAll()
		.antMatchers(HttpMethod.POST, "/api/representantes").permitAll()
		.antMatchers(HttpMethod.GET, "/api/representantes/{id_Representante}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/representantes/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/representantes/cedula/{cedula_Representante}").permitAll()
		
		.antMatchers(HttpMethod.GET, "/api/antecedente").permitAll()
		.antMatchers(HttpMethod.POST, "/api/antecedente").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/antecedente/{id}").permitAll()

				
				
		.antMatchers(HttpMethod.GET, "/api/discapacidad").permitAll()
		.antMatchers(HttpMethod.POST, "/api/discapacidad").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/discapacidad/{id}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/estadoCivil").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/genero").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/nivelEducacion").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/tiposDiscapacidades").permitAll()
		.antMatchers(HttpMethod.POST, "api/tiposDiscapacidades").permitAll()
		.antMatchers(HttpMethod.GET, "/api/tiposDiscapacidades/{id_TipoDiscapacidad}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/tipoSangre").permitAll()
		
		
		
		.antMatchers(HttpMethod.GET, "/api/tiposTrabajos").permitAll()
		.antMatchers(HttpMethod.POST, "/api/tiposTrabajos").permitAll()
		.antMatchers(HttpMethod.GET, "/api/tiposTrabajos/{id_TipoTrabajo}").permitAll()
		
		
		.antMatchers(HttpMethod.GET, "/api/trabajos").permitAll()
		.antMatchers(HttpMethod.POST, "/api/trabajos").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/trabajos/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/unidadesEducativas").permitAll()
		
		.antMatchers(HttpMethod.PUT, "/api/unidadesEducativas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/unidadesEducativas").permitAll()
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	
}
