package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.repository.IProfesionProfesionalRepository;

@Service
public class ProfesionProfesionalServiceImpl  implements IProfesionProfesionalService{
	@Autowired
	private IProfesionProfesionalRepository profesionProfesional;

	@Override
	public List<ProfesionProfesional> findAll() {
		return (List<ProfesionProfesional>) profesionProfesional.findAll();
	}

	@Override
	public ProfesionProfesional findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfesionProfesional save(ProfesionProfesional profesionProfesional) {
		// TODO Auto-generated method stub
		return null;
	}

}
