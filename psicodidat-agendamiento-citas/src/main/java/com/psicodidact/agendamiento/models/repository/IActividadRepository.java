package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Actividad;


public interface IActividadRepository  extends CrudRepository<Actividad, Long>{

}
