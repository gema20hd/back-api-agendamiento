package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Trabajo;

public interface ITrabajoRepository extends CrudRepository<Trabajo, Long>{

}
