package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Asistencia;
import com.psicodidact.agendamiento.models.entity.DetalleCompra;
import com.psicodidact.agendamiento.models.repository.IDetalleCompraRepository;


@Service
public class DetalleCompraServiceImpl implements  IDetalleService{

	@Autowired
	private IDetalleCompraRepository idetalleCompraRepository;
	
	@Override
	public List<DetalleCompra> findAll() {
		// TODO Auto-generated method stub
		return  (List<DetalleCompra>) idetalleCompraRepository.findAll();
	}

	@Override
	public Page<DetalleCompra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleCompra findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleCompra save(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
