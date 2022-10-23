package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.repository.ITipoDiscapacidadRepository;

@Service
public class TipoDiscapacidadServiceImpl implements ITipoDiscapacidadService{
	
	@Autowired
	private ITipoDiscapacidadRepository tipoDiscapacidad;

	@Override
	public List<TipoDiscapacidad> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoDiscapacidad>) tipoDiscapacidad.findAll();
	}

	@Override
	public TipoDiscapacidad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoDiscapacidad save(TipoDiscapacidad tipoDiscapacidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
