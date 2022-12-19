package com.psicodidact.agendamiento.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Antecedente;



public interface IAntecedentesService {

	public List<Antecedente> findAll();
	
	public Page<Antecedente> findAll(Pageable pageable);
	
	public Antecedente findById(Long id);
	
	public Antecedente save(Antecedente Antecedentes);
	
	public void delete(Long id);
	
	
	public Antecedente actualizar(Antecedente antecedentes);
	


}