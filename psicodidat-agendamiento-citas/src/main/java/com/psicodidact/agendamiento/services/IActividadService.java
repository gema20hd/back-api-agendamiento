package com.psicodidact.agendamiento.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Actividad;



public interface IActividadService {

	public List<Actividad> findAll();
	
	public Page<Actividad> findAll(Pageable pageable);
	
	public Actividad findById(Long id);
	
	public Actividad save(Actividad Actividad);
	
	public void delete(Long id);
	


}
