package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.PacienteProfesional;



public interface IPacienteProfesionalService {

	public List<PacienteProfesional> findAll();
	
	public Page<PacienteProfesional> findAll(Pageable pageable);
	
	public PacienteProfesional findById(Long id);
	
	public PacienteProfesional save(PacienteProfesional pacienteProfesional);
	
	public void delete(Long id);
	
	
}
