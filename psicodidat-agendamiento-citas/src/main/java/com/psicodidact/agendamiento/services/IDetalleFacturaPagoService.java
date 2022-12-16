package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.DetalleFacturaPago;



public interface IDetalleFacturaPagoService {

	
	public List<DetalleFacturaPago> findAll();
	
	public Page<DetalleFacturaPago> findAll(Pageable pageable);
	
	public DetalleFacturaPago findById(Long id);
	
	public DetalleFacturaPago save(DetalleFacturaPago detalleFacturaPago);
	
	public void delete(Long id);
}
