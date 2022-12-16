package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.Oficina;
import com.psicodidact.agendamiento.models.repository.IOficinaRepository;


@Service
public class OficinaServiceImpl implements IOficinaService{

	@Autowired
	private IOficinaRepository iOficina;
	
	@Override
	public List<Oficina> findAll() {
		// TODO Auto-generated method stub
		return (List<Oficina>) iOficina.findAll();
	}

	@Override
	public Page<Oficina> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oficina findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oficina save(Oficina oficina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
