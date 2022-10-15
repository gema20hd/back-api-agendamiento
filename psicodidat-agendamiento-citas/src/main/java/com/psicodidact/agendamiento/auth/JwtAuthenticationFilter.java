package com.psicodidact.agendamiento.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.psicodidact.agendamiento.services.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;
 
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       

    	String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
              
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

            try{
                username = this.jwtUtil.extractUsername(jwtToken);
            }catch (ExpiredJwtException exception){
                System.out.println("El token ha expirado");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            System.out.println("Token invalido , no empieza con bearer string");
        }
        //SecurityContextHolder
        //almacena los detalles de quien esta autenticado
      //  SecurityContextHolder.getContext().getAuthentication() == null ,, si no existe un objeto autenticado
        System.out.println("ingresa metodo 1");
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
        	 System.out.println("ingresa metodo 2");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(this.jwtUtil.validateToken(jwtToken,userDetails)){
            	 System.out.println("ingresa metodo 3");
            	//asigna el usuario, las constrasenas para que sean utilizados por el conteneodr de autenticacion
            	//autenticationmanager/autentication  provider
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
   //agrega los detalles de  UsernamePasswordAuthenticationToken
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("El token no es valido");
        }
        filterChain.doFilter(request,response);
    }
}
