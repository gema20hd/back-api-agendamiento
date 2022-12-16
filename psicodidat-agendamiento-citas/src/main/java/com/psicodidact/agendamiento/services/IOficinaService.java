package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Oficina;



public interface IOficinaService {

	

	public List<Oficina> findAll();
	
	public Page<Oficina> findAll(Pageable pageable);
	
	public Oficina findById(Long id);
	
	public Oficina save(Oficina oficina);
	
	public void delete(Long id);
}
