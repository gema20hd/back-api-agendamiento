package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.HorarioActividad;



public interface IHorarioActividadService {

	public List<HorarioActividad> findAll();
	
	public Page<HorarioActividad> findAll(Pageable pageable);
	
	public HorarioActividad findById(Long id);
	
	public HorarioActividad save(HorarioActividad horarioActividad);
	
	public void delete(Long id);
	
	
	
}
