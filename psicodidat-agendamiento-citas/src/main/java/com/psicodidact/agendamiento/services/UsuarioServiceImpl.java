package com.psicodidact.agendamiento.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.activation.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IUsuarioRepository;



@Service
public class UsuarioServiceImpl  implements IUsuarioService, UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getDescripcionRol()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		Usuario user = new Usuario(usuarioCorreo(usuario.getUsername()), 
				passwordEncry(usuario.getPassword()),usuario.isEnabled(),usuario.getProfesional());
		Usuario usernew= usuarioRepository.save(user);
		return usernew;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
		
	}

	public String usuarioCorreo(String u) {
		String[] usuario = null;
		usuario = u.split("@");
		String us = username(usuario);
		
		return us;

	}

	public  String username(String[] MyArray) {
		String t = "";
		
		for (int i = 0; i <= MyArray.length - 1; i++) {
			t = MyArray[0];
			
		}
		return t;
	}

	public String passwordEncry(String password) {
		String passwordBcrypt = passwordEncoder.encode(password);
		System.out.println("Hola usuario service......"+passwordBcrypt);
		return passwordBcrypt;
	}

	@Override
	public Integer insertRolesDeUsuario(Long id,Long idRol) {
		return usuarioRepository.insertUsuarioRoles(id,idRol);
		
	}



}
