package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.psicodidact.agendamiento.models.entity.SubServicio;

public interface ISubServicioService {

	public List<SubServicio> findAll();
	
	public Page<SubServicio> findAll(Pageable pageable);
	
	public SubServicio findById(Long id);
	
	public SubServicio save(SubServicio subServicio);
	
	public void delete(Long id);
	
}
