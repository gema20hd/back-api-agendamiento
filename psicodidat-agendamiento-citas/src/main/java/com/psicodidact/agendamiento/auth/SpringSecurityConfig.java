package com.psicodidact.agendamiento.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



//Especificar las confiuraciones de acceso a los recursos publicados
//se permiten todas las llamadas al endpoint  usuarios
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	   @Autowired
	    private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	   @Autowired
	    private JwtAuthenticationFilter jwtAuthenticationFilter;

	 

	 @Override
	    //@Bean metodo administrado por el contexto de spring
	   // El AuthenticationManager es realmente solo un contenedor 
	   // para proveedores de autenticación, que les brinda una interfaz coherente a todos ellos.
	    @Bean
	    //AuthenticationManager Contenedor para proveedores de autenticacion
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	    	System.out.println(" authenticationManagerBean");
	        return super.authenticationManagerBean();
	    }
	 
	 @Bean
	    //encriptar la contrasena
	    public PasswordEncoder passwordEncoder(){
	    	System.out.println("METODO passwordEncoder");
	    //public BCryptPasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    //	return new BCryptPasswordEncoder();
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	System.out.println(" configure(HttpSecurity http)");
	        http
	                .csrf()
	                .disable()
	                .cors()
	                .disable()
	                .authorizeRequests()
	                .antMatchers("/generate-token","/usuarios/").permitAll()
	                .antMatchers(HttpMethod.OPTIONS).permitAll()
	                .anyRequest().authenticated()
	                .and()
	                //JwtAuthenticationEntryPoint=mensaje de error para usuarios no autorizados
	                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	       // jwtAuthenticationFilter==intercepcion de filtros
	        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    }
	
}
