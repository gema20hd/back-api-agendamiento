package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;


public interface IProfesionProfesionalService {
	public List<ProfesionProfesional> findAll();

	public ProfesionProfesional findById(Long id);

	public ProfesionProfesional save(ProfesionProfesional profesionProfesional);
}
