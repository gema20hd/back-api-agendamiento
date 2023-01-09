package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Profesion;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;

public interface IProfesionService {
	List<Profesion> findAll();

	Profesion findById(Long id);

	Profesion save(Profesion profesion);
	
	public List<Profesion> findByDescripcionProfesionContainingIgnoreCase(String term);
	
}
