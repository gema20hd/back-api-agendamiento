package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Profesion;

public interface IProfesionService {
	List<Profesion> findAll();

	Profesion findById(Long id);

	Profesion save(Profesion profesion);
}
