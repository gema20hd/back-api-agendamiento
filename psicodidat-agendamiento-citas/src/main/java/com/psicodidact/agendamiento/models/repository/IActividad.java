package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Actividad;


public interface IActividad  extends CrudRepository<Actividad, Long>{

}
