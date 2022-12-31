package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Paquete;
import com.psicodidact.agendamiento.models.entity.Servicio;



public interface IPaqueteService {

	
	public List<Paquete> findAll();
	
	public Page<Paquete> findAll(Pageable pageable);
	
	public Paquete findById(Long id);
	
	public Paquete save(Paquete paquete);
	
	public void delete(Long id);
	
	
}
