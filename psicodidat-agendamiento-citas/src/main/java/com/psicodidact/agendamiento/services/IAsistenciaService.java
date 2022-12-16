package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Asistencia;



public interface IAsistenciaService {

public List<Asistencia> findAll();
	
	public Page<Asistencia> findAll(Pageable pageable);
	
	public Asistencia findById(Long id);
	
	public Asistencia save(Asistencia asistencia);
	
	public void delete(Long id);
	
	
}
