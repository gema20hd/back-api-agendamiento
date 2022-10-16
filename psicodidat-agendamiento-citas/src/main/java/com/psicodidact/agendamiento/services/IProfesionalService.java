package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Profesional;



public interface IProfesionalService {

	public List<Profesional> findAll();
	
	public Page<Profesional> findAll(Pageable pageable);
	
	public Profesional findById(Long id);
	
	public Profesional save(Profesional profesional);
	
	public void delete(Long id);
	


}
