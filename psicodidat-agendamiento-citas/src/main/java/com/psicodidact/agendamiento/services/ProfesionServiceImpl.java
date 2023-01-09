package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Profesion;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.IProfesionRepository;

@Service
public class ProfesionServiceImpl implements  IProfesionService {

	@Autowired
	private IProfesionRepository profesion;
	@Override
	public List<Profesion> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesion>) profesion.findAll();
	}

	@Override
	public Profesion findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesion save(Profesion profesion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesion> findByDescripcionProfesionContainingIgnoreCase(String term) {
		// TODO Auto-generated method stub
		return profesion.findByDescripcionProfesionContainingIgnoreCase(term);
	}
	
	


}
