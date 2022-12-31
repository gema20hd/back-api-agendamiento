package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.FacturaCompra;
import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.repository.IFacturaCompraRepository;
import com.psicodidact.agendamiento.models.repository.IFacturaDetalleCompraRepository;
import com.psicodidact.agendamiento.models.repository.IRolRepository;

@Service
public class FacturaCompraServiceImpl  implements IFacturaCompraService{
	
	@Autowired
	private IFacturaCompraRepository iFacturaCompra;

	@Override
	public List<FacturaCompra> findAll() {
		return (List<FacturaCompra>) iFacturaCompra.findAll();
	}

	@Override
	public Page<FacturaCompra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaCompra findById(Long id) {
		return iFacturaCompra.findById(id).orElse(null);
	}

	@Override
	public FacturaCompra save(FacturaCompra factura) {
		return iFacturaCompra.save(factura);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
