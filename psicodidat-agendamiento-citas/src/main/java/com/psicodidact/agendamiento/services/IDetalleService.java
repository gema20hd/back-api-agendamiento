package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.DetalleCompra;



public interface IDetalleService {
	public List<DetalleCompra> findAll();
	
	public Page<DetalleCompra> findAll(Pageable pageable);
	
	public DetalleCompra findById(Long id);
	
	public DetalleCompra save(DetalleCompra detalleCompra);
	
	public void delete(Long id);
}
