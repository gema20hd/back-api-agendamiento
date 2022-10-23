package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.TipoSangre;


public interface ITipoSangreService {
	
	List<TipoSangre> findAll();

	TipoSangre findById(Long id);

	TipoSangre save(TipoSangre tipoSangre);
	

}
