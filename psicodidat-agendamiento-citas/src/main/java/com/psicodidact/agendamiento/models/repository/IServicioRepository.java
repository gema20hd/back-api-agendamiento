package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Servicio;

public interface IServicioRepository extends CrudRepository<Servicio, Long>{

}
