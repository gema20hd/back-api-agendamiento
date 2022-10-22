package com.psicodidact.agendamiento.services;

import java.util.List;

import com.psicodidact.agendamiento.models.entity.Rol;


public interface IRolService {
	List<Rol> findAll();

	Rol findById(Long id);

	Rol save(Rol rol);
}
