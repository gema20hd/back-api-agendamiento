package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.ServicioCompra;



public interface IServicioCompraService {

	
	public List<ServicioCompra> findAll();
	
	public Page<ServicioCompra> findAll(Pageable pageable);
	
	public ServicioCompra findById(Long id);
	
	public ServicioCompra save(ServicioCompra servicioCompra);
	
	public void delete(Long id);
	
}
