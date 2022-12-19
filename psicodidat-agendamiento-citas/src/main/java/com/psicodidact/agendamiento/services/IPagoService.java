package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Pago;



public interface IPagoService {

	
	public List<Pago> findAll();
	
	public Page<Pago> findAll(Pageable pageable);
	
	public Pago findById(Long id);
	
	public Pago save(Pago pago);
	
	public void delete(Long id);
}
