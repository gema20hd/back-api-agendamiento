package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Banco;



public interface IBancoService {

	public List<Banco> findAll();
	
	//public Page<Banco> findAll(Pageable pageable);
	
	public Banco findById(Long id);
	
	public Banco save(Banco Banco);
	
	public void delete(Long id);
	
	
	


}