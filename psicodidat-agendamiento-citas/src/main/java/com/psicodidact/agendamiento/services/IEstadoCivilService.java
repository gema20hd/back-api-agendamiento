package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.EstadoCivil;



public interface IEstadoCivilService {

	public List<EstadoCivil> findAll();
	
	public Page<EstadoCivil> findAll(Pageable pageable);
	
	public EstadoCivil findById(Long id);
	
	public EstadoCivil save(EstadoCivil EstadoCivil);
	
	public void delete(Long id);
	


}