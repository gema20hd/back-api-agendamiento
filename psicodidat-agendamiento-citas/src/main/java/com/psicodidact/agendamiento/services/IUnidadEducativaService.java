package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Especialidad;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;

public interface IUnidadEducativaService {

	List<UnidadEducativa> findAll();

	UnidadEducativa findById(Long id);

	UnidadEducativa save(UnidadEducativa unidad);
	
	public List<UnidadEducativa> findByNombreUnidadEducativaContainingIgnoreCase(String term);
}
