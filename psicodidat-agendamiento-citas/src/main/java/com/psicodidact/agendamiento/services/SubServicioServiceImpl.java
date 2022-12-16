package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.SubServicio;
import com.psicodidact.agendamiento.models.repository.ISubServicioRepository;


@Service
public class SubServicioServiceImpl implements ISubServicioService{

	
	@Autowired
	private ISubServicioRepository iSubServicio;
	
	@Override
	public List<SubServicio> findAll() {
		// TODO Auto-generated method stub
		return (List<SubServicio>) iSubServicio.findAll();
	}

	@Override
	public Page<SubServicio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubServicio findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubServicio save(SubServicio subServicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
