package com.psicodidact.agendamiento.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.IUnidadEducativaRepository;

@Service
public class UnidadEducativaImpl  implements IUnidadEducativaService{
	
	@Autowired
	private IUnidadEducativaRepository unidadEducativa;

	@Override
	@Transactional()
	public List<UnidadEducativa> findAll() {
		return (List<UnidadEducativa>) unidadEducativa.findAll();
	}

	
	@Override
	@Transactional()
	public UnidadEducativa findById(Long id) {
		return unidadEducativa.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public UnidadEducativa save(UnidadEducativa unidad) {
		return unidadEducativa.save(unidad);
	}




}
