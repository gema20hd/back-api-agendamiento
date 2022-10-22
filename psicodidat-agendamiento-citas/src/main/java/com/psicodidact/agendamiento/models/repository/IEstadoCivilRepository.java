package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.EstadoCivil;


public interface IEstadoCivilRepository extends CrudRepository<EstadoCivil, Long> {

}
