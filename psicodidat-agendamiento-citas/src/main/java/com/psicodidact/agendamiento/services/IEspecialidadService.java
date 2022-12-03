package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Especialidad;

public interface IEspecialidadService {

	public List<Especialidad> findAll();
	
	public Especialidad findById(Long id);
	
	public Especialidad save(Especialidad especialidad);
	
	public void delete(Long id);

}