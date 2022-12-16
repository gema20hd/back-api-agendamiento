package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.psicodidact.agendamiento.models.entity.Evaluacion;

public interface IEvaluacionService {

	
    public List<Evaluacion> findAll();
	
	public Page<Evaluacion> findAll(Pageable pageable);
	
	public Evaluacion findById(Long id);
	
	public Evaluacion save(Evaluacion evaluacion);
	
	public void delete(Long id);
	
	
	
	
}
