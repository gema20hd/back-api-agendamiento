package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IDiscapacidadRepository;

@Service
public class DiscapacidadServiceImpl  implements IDiscapacidadService {

	
	@Autowired
	private IDiscapacidadRepository iDiscapacidad;

	@Override
	public List<Discapacidad> findAll() {
		// TODO Auto-generated method stub
		return (List<Discapacidad>) iDiscapacidad.findAll();
	}
	@Override
	public Page<Discapacidad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Discapacidad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Discapacidad save(Discapacidad Discapacidad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

