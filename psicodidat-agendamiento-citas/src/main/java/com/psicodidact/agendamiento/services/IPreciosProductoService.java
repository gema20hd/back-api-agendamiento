package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.PreciosProducto;
import com.psicodidact.agendamiento.models.entity.Servicio;



public interface IPreciosProductoService {

	
	public List<PreciosProducto> findAll();
	
	public Page<PreciosProducto> findAll(Pageable pageable);
	
	public PreciosProducto findById(Long id);
	
	public PreciosProducto save(PreciosProducto precio);
	
	public void delete(Long id);
	
	
}
