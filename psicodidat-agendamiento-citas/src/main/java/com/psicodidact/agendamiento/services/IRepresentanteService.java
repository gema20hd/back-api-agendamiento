package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Representante;



public interface IRepresentanteService {
	List<Representante> findAll();

	Representante findById(Long id);

	Representante save(Representante representate);
	
     void eliminar(Long id);
	
	Representante actualizar(Representante representate);
	
	
   Representante buscarPorCedulaRepresentante(String identificacionRepresentante);
	
}
