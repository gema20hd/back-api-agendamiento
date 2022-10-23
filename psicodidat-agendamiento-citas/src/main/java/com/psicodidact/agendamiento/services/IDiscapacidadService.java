package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Discapacidad;



public interface IDiscapacidadService {

	public List<Discapacidad> findAll();
	
	public Page<Discapacidad> findAll(Pageable pageable);
	
	public Discapacidad findById(Long id);
	
	public Discapacidad save(Discapacidad Discapacidad);
	
	public void delete(Long id);
	


}