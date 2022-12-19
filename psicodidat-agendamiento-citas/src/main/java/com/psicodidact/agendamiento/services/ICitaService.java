package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.psicodidact.agendamiento.models.entity.Cita;

public interface ICitaService {

	
public List<Cita> findAll();
	
	public Page<Cita> findAll(Pageable pageable);
	
	public Cita findById(Long id);
	
	public Cita save(Cita cita);
	
	public void delete(Long id);
}
