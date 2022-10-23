package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.Usuario;


public interface IRolRepository  extends CrudRepository<Rol, Long>{
	@Query("select r from Rol r where r.descripcionRol=?1")
	public Rol findByRole(String descripcionRol);

}
