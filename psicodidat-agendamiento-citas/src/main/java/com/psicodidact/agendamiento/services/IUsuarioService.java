package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
	
	public Integer insertRolesDeUsuario(Long id, Long idRol);
}
