package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	public Rol insertRolesDeUsuario(Long id, Long idRol);
}
