package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Servicio;

public interface IServicioRepository extends CrudRepository<Servicio, Long>{
	
	
	public List<Servicio> findBydescripcionServicioContainingIgnoreCase(String term);
}
