package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Servicio;
import com.psicodidact.agendamiento.models.repository.IServicioRepository;

@Service
public class ServicioServiceImpl implements IServicioService{

	@Autowired
	private IServicioRepository iservicio;
	
	
	@Override
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>) iservicio.findAll();
	}

	@Override
	public Page<Servicio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio save(Servicio servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
