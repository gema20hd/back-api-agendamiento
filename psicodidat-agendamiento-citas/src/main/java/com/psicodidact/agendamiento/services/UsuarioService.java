package com.psicodidact.agendamiento.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicodidact.agendamiento.models.dao.IUsuarioDao;
import com.psicodidact.agendamiento.models.entity.Usuario;

@Service
public class UsuarioService  implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		List<GrantedAuthority> rol = usuario.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getDescripcionRol()))
				.peek(authority -> logger.info("Rol: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return   new User(usuario.getNombreUsuario(), usuario.getClaveUsuario(), usuario.getEstado(), true, true, true, rol);
	}
	


}
