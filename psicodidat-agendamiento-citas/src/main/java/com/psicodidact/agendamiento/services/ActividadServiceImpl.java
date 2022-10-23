package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.repository.IActividadRepository;

@Service
public class ActividadServiceImpl  implements IActividadService {

	
	@Autowired
	private IActividadRepository iActividad;

	@Override
	public List<Actividad> findAll() {
		// TODO Auto-generated method stub
		return (List<Actividad>) iActividad.findAll();
	}
	@Override
	public Page<Actividad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Actividad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Actividad save(Actividad Actividad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
