package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;



public interface IDiscapacidadService {

	public List<Discapacidad> findAll();
	
	public Discapacidad findById(Long id);
	
	public Discapacidad save(Discapacidad discapacidad);
	
	public void delete(Long id);
	
	public List<TipoDiscapacidad> findAllTypeDisability();
	

	public Discapacidad actualizarDiscapacidad(Discapacidad discapacidad);
}