package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IDiscapacidadRepository;

@Service
public class DiscapacidadServiceImpl  implements IDiscapacidadService {

	
	@Autowired
	private IDiscapacidadRepository iDiscapacidad;

	@Override
	public List<Discapacidad> findAll() {
		return (List<Discapacidad>) iDiscapacidad.findAll();
	}

	@Override
	public Discapacidad findById(Long id) {
		return iDiscapacidad.findById(id).orElse(null);
	}

	@Override
	public Discapacidad save(Discapacidad discapacidad) {
		return iDiscapacidad.save(discapacidad);
	}

	@Override
	public void delete(Long id) {
		iDiscapacidad.deleteById(id);
		
	}

	@Override
	public List<TipoDiscapacidad> findAllTypeDisability() {
		return iDiscapacidad.findAllTypeDisability();
	}

	

}

