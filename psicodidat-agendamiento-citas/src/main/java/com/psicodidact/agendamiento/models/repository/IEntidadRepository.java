package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Entidad;
;

public interface IEntidadRepository  extends CrudRepository<Entidad, Long>{

}
