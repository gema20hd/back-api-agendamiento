package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.FacturaPago;

import com.psicodidact.agendamiento.models.repository.IFacuraPagoRepository;


@Service
public class FacturaPagoServiceImpl implements IFacturaPagoService{

	@Autowired
	private IFacuraPagoRepository ifacuraPago;
	
	
	@Override
	public List<FacturaPago> findAll() {
		// TODO Auto-generated method stub
		return (List<FacturaPago>) ifacuraPago.findAll();
	}

	@Override
	public Page<FacturaPago> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaPago findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaPago save(FacturaPago facturaPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
