package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.FacturaDetalleCompra;
import com.psicodidact.agendamiento.models.entity.Paquete;
import com.psicodidact.agendamiento.models.entity.Servicio;



public interface IFacturaDetalleCompraService {

	
	public List<FacturaDetalleCompra> findAll();
	
	public Page<FacturaDetalleCompra> findAll(Pageable pageable);
	
	public FacturaDetalleCompra findById(Long id);
	
	public FacturaDetalleCompra save(FacturaDetalleCompra detalle);
	
	public void delete(Long id);
	
	
}
