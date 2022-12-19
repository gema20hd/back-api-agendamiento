package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.repository.ITipoCuentaRepository;

@Service
public class TipoCuentaServiceImpl  implements ITipoCuentaService{

	
	@Autowired
	private ITipoCuentaRepository ITipoCuenta;
	
	@Override
	public List<TipoCuenta> findAll() {
		return (List<TipoCuenta>) ITipoCuenta.findAll();
	}

	@Override
	public TipoCuenta findById(Long id) {
		return ITipoCuenta.findById(id).orElse(null);
	}

	@Override
	public TipoCuenta save(TipoCuenta tipoCuenta) {
		return ITipoCuenta.save(tipoCuenta);
	}

	@Override
	public void delete(Long id) {
		ITipoCuenta.deleteById(id);
		
	}

}
