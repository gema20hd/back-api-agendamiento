package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Usuario;

public interface IUsuarioDao  extends CrudRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.nombreUsuario=?1")
	public Usuario findByUsername(String nombreUsuario);
	
}
