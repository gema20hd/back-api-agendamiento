package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Entidad;



public interface IEntidadService {

	public List<Entidad> findAll();
	
	public Page<Entidad> findAll(Pageable pageable);
	
	public Entidad findById(Long id);
	
	public Entidad save(Entidad Entidad);
	
	public void delete(Long id);
	


}
