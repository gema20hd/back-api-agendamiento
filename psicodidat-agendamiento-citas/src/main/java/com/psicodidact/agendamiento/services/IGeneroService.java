package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Genero;



public interface IGeneroService {

	public List<Genero> findAll();
	
	public Page<Genero> findAll(Pageable pageable);
	
	public Genero findById(Long id);
	
	public Genero save(Genero Genero);
	
	public void delete(Long id);
	


}
