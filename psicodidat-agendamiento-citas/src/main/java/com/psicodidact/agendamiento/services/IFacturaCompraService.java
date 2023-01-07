package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.FacturaCompra;
import com.psicodidact.agendamiento.models.entity.Servicio;



public interface IFacturaCompraService {

	
	public List<FacturaCompra> findAll();
	
	public Page<FacturaCompra> findAll(Pageable pageable);
	
	public FacturaCompra findById(Long id);
	
	public FacturaCompra save(FacturaCompra factura);
	
	public void deleteFacturaById (Long id);
	
	
}
