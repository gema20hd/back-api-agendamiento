package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.PacienteProfesional;
import com.psicodidact.agendamiento.models.repository.IPacienteProfesionalRepository;

@Service
public class PacienteProfesionalServiceImpl implements IPacienteProfesionalService{

	
	@Autowired
	private IPacienteProfesionalRepository iPacienteProfesional;
	
	@Override
	public List<PacienteProfesional> findAll() {
		// TODO Auto-generated method stub
		return (List<PacienteProfesional>) iPacienteProfesional.findAll();
	}

	@Override
	public Page<PacienteProfesional> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteProfesional findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteProfesional save(PacienteProfesional pacienteProfesional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
