package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.Sucursal;
import com.psicodidact.agendamiento.models.repository.ISucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService{

	@Autowired
	
	private ISucursalRepository isucursal;
	
	
	@Override
	public List<Sucursal> findAll() {
		// TODO Auto-generated method stub
		return (List<Sucursal>) isucursal.findAll();
	}

	@Override
	public Page<Sucursal> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sucursal findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sucursal save(Sucursal sucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
