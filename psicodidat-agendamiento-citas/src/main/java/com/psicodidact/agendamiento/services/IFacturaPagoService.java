package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.psicodidact.agendamiento.models.entity.FacturaPago;

public interface IFacturaPagoService {

public List<FacturaPago> findAll();
	
	public Page<FacturaPago> findAll(Pageable pageable);
	
	public FacturaPago findById(Long id);
	
	public FacturaPago save(FacturaPago facturaPago);
	
	public void delete(Long id);
	
	
	
	
}
