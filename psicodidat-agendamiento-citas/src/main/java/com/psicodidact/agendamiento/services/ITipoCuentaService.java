package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.TipoCuenta;


public interface ITipoCuentaService {

	List<TipoCuenta> findAll();

	TipoCuenta findById(Long id);

	TipoCuenta save(TipoCuenta tipoCuenta);
	
	public void delete(Long id);

}
