package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Trabajo;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;

public interface ITrabajoService {
	
	List<Trabajo> findAll();

	Trabajo findById(Long id);

	Trabajo save(Trabajo trabajo);

}
