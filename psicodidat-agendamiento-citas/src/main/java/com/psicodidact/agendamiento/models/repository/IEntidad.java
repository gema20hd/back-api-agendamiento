package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Entidad;
;

public interface IEntidad  extends CrudRepository<Entidad, Long>{

}
