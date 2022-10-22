package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;


public interface ITipoDiscapacidadService {
	
	List<TipoDiscapacidad> findAll();

	TipoDiscapacidad findById(Long id);

	TipoDiscapacidad save(TipoDiscapacidad tipoDiscapacidad);

}
