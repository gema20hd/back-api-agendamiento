package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;



public interface ICuentaService {

	public List<Cuenta> findAll();
	
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta Cuenta);
	
	public void delete(Long id);

	public List<TipoCuenta> findAllAccounType();
	
	public List<Banco> findAllBank();
	
	public List<Banco> findByDescripcionBancoContainingIgnoreCase(String term);

	public Banco findByBank(Long id);
	
	public Cuenta findByNumeroCuenta(String nuemroCuenta);




}