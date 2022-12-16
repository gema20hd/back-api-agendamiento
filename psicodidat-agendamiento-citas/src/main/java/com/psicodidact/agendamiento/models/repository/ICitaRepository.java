package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Cita;

public interface ICitaRepository extends CrudRepository<Cita, Long>{

}
