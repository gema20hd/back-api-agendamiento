package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.DetalleFacturaPago;
import com.psicodidact.agendamiento.models.repository.IDetalleFacturaPagoRepository;


@Service
public class DetalleFacturaPagoServiceImpl implements IDetalleFacturaPagoService{

	@Autowired
	private  IDetalleFacturaPagoRepository idetalleFacturaPagoRepository;
	
	@Override
	public List<DetalleFacturaPago> findAll() {
		// TODO Auto-generated method stub
		return (List<DetalleFacturaPago>) idetalleFacturaPagoRepository.findAll();
	}

	@Override
	public Page<DetalleFacturaPago> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleFacturaPago findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleFacturaPago save(DetalleFacturaPago detalleFacturaPago) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
