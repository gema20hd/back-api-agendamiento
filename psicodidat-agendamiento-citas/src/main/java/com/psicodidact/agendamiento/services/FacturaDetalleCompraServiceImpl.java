package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.FacturaDetalleCompra;
import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.repository.IFacturaDetalleCompraRepository;
import com.psicodidact.agendamiento.models.repository.IRolRepository;
import com.psicodidact.agendamiento.models.repository.IUnidadEducativaRepository;

@Service
public class FacturaDetalleCompraServiceImpl  implements IFacturaDetalleCompraService{
	
	@Autowired
	private IFacturaDetalleCompraRepository iFacturaDetalleCompra;

	@Override
	public List<FacturaDetalleCompra> findAll() {
		return (List<FacturaDetalleCompra>) iFacturaDetalleCompra.findAll();
	}

	@Override
	public Page<FacturaDetalleCompra> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaDetalleCompra findById(Long id) {
		return iFacturaDetalleCompra.findById(id).orElse(null);
	}

	@Override
	public FacturaDetalleCompra save(FacturaDetalleCompra detalle) {
		return iFacturaDetalleCompra.save(detalle);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
