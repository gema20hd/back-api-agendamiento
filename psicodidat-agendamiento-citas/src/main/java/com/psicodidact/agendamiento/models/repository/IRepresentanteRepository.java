package com.psicodidact.agendamiento.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Representante;


public interface IRepresentanteRepository extends CrudRepository<Representante, Long>{
	Representante  findByIdentificacionRepresentante(String identificacionRepresentante);
}
