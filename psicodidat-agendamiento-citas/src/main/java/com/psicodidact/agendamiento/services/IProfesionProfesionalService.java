package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;


public interface IProfesionProfesionalService {
	List<ProfesionProfesional> findAll();

	ProfesionProfesional findById(Long id);

	ProfesionProfesional save(ProfesionProfesional profesionProfesional);
}
