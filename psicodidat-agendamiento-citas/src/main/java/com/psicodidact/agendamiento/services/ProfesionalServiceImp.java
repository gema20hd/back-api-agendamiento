package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IProfesionalRepository;

@Service
public class ProfesionalServiceImp  implements IProfesionalService {

	
	@Autowired
	private IProfesionalRepository iProfesional;

	@Override
	public List<Profesional> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesional>) iProfesional.findAll();
	}
	@Override
	public Page<Profesional> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Profesional findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Profesional save(Profesional profesional) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
