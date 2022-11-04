package com.psicodidact.agendamiento.models.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Profesional;



public interface IProfesionalRepository extends CrudRepository<Profesional, Long>{
	
}
