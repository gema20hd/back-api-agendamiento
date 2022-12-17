package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;


public interface IProfesionProfesionalRepository extends CrudRepository<ProfesionProfesional, Long> {
	
	@Query("select b from ProfesionProfesional b where b.idProfesionProfesional=?1")
	public ProfesionProfesional findByIdProfesionProfesional(Long id);
}
