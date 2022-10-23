package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.repository.ITipoCuentaRepository;

@Service
public class TipoCuentaServiceImpl  implements ITipoCuentaService{

	
	@Autowired
	private ITipoCuentaRepository tipoCuenta;
	@Override
	public List<TipoCuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoCuenta>) tipoCuenta.findAll();
	}

	@Override
	public TipoCuenta findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCuenta save(TipoCuenta tipoDiscapacidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
