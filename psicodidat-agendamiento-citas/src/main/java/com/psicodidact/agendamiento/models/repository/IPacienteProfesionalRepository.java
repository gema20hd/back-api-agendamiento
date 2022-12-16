package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.PacienteProfesional;

public interface IPacienteProfesionalRepository extends CrudRepository<PacienteProfesional, Long>{

}
