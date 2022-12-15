package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;


public interface IDiscapacidadRepository extends CrudRepository<Discapacidad, Long> {

	@Query("select td from TipoDiscapacidad td")
	public List<TipoDiscapacidad> findAllTypeDisability();
	
}
