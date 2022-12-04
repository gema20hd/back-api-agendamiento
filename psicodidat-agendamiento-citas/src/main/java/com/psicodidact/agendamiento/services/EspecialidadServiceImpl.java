package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Especialidad;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.IEspecialidadRepository;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService{
	
	@Autowired
	private IEspecialidadRepository iEspecialidad;

	@Override
	public List<Especialidad> findAll() {
		return (List<Especialidad>) iEspecialidad.findAll();
	}

	
	@Override
	public Especialidad findById(Long id) {
		return (Especialidad) iEspecialidad.findById(id).orElse(null);
	}

	@Override
	public Especialidad save(Especialidad especialidad) {
		return iEspecialidad.save(especialidad);
	}

	@Override
	public void delete(Long id) {
		iEspecialidad.deleteById(id);
	}


	@Override
	public List<Especialidad> findByDescripcionEspecialidadContainingIgnoreCase(String term) {
		return  iEspecialidad.findByDescripcionEspecialidadContainingIgnoreCase(term);
	}





	

}