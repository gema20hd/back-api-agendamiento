package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Compra;
import com.psicodidact.agendamiento.models.repository.ICompraRepository;


@Service
public class CompraServiceImpl implements ICompraService{

	@Autowired
	private ICompraRepository icompraRepository;
	
	@Override
	public List<Compra> findAll() {
		return (List<Compra>) icompraRepository.findAll();
	}

	@Override
	public Page<Compra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra save(Compra Actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
