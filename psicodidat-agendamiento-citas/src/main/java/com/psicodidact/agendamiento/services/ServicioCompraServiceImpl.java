package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.ServicioCompra;
import com.psicodidact.agendamiento.models.repository.IServicioCompraRepository;


@Service
public class ServicioCompraServiceImpl implements IServicioCompraService{

	@Autowired
	private IServicioCompraRepository iServicioCompra;
	
	
	@Override
	public List<ServicioCompra> findAll() {
		// TODO Auto-generated method stub
		return (List<ServicioCompra>) iServicioCompra.findAll();
	}

	@Override
	public Page<ServicioCompra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicioCompra findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicioCompra save(ServicioCompra servicioCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
