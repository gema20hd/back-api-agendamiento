package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.EstadoCivil;


public interface IEstadoCivil extends CrudRepository<EstadoCivil, Long> {

}
