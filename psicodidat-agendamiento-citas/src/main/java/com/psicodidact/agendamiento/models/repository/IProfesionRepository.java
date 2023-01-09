package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.psicodidact.agendamiento.models.entity.Profesion;



public interface IProfesionRepository extends CrudRepository<Profesion, Long>{

	
	public List<Profesion> findByDescripcionProfesionContainingIgnoreCase(String term);
	
}
