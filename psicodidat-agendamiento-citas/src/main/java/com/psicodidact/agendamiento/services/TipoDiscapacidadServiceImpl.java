package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.repository.ITipoDiscapacidadRepository;

@Service
public class TipoDiscapacidadServiceImpl implements ITipoDiscapacidadService{
	
	@Autowired
	private ITipoDiscapacidadRepository itipoDiscapacidad;

	@Override
	public List<TipoDiscapacidad> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoDiscapacidad>) itipoDiscapacidad.findAll();
	}

	@Override
	public TipoDiscapacidad findById(Long id) {
		// TODO Auto-generated method stub
		return itipoDiscapacidad.findById(id).get();
	}

	@Override
	public TipoDiscapacidad save(TipoDiscapacidad tipoDiscapacidad) {
		// TODO Auto-generated method stub
		return itipoDiscapacidad.save(tipoDiscapacidad);
	}

}
