package com.psicodidact.agendamiento.services;

import java.util.List;


import com.psicodidact.agendamiento.models.entity.TipoTrabajo;

public interface ITipoTrabajoService {

	
	List<TipoTrabajo> findAll();

	TipoTrabajo findById(Long id);
	
	TipoTrabajo save(TipoTrabajo tipoTrabajo);

}
