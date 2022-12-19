package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Compra;



public interface ICompraService {
public List<Compra> findAll();
	
	public Page<Compra> findAll(Pageable pageable);
	
	public Compra findById(Long id);
	
	public Compra save(Compra Actividad);
	
	public void delete(Long id);
}
