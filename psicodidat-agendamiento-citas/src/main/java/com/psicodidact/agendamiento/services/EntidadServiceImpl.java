package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Entidad;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IEntidadRepository;

@Service
public class EntidadServiceImpl  implements IEntidadService {

	
	@Autowired
	private IEntidadRepository iEntidad;

	@Override
	public List<Entidad> findAll() {
		// TODO Auto-generated method stub
		return (List<Entidad>) iEntidad.findAll();
	}
	@Override
	public Page<Entidad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entidad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entidad save(Entidad Entidad) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
