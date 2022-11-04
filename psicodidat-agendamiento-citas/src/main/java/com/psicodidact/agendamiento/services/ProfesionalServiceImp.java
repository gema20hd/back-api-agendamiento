package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.repository.IProfesionalRepository;

@Service
public class ProfesionalServiceImp  implements IProfesionalService {

	
	@Autowired
	private IProfesionalRepository profesional;

	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findAll() {	
		return (List<Profesional>) this.profesional.findAll();
	}



	
}
