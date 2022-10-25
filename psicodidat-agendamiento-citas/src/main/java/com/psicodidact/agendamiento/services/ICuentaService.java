package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Cuenta;



public interface ICuentaService {

	public List<Cuenta> findAll();
	
	public Page<Cuenta> findAll(Pageable pageable);
	
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta Cuenta);
	
	public void delete(Long id);
	


}