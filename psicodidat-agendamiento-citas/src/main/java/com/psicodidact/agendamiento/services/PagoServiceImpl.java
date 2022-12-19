package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.Pago;
import com.psicodidact.agendamiento.models.repository.IPagoRepository;

@Service
public class PagoServiceImpl implements IPagoService{
	
	@Autowired
	private IPagoRepository iPago;
	

	@Override
	public List<Pago> findAll() {
		// TODO Auto-generated method stub
		return (List<Pago>) iPago.findAll();
	}

	@Override
	public Page<Pago> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pago findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pago save(Pago pago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
