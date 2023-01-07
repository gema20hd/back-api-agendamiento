package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.PreciosProducto;
import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.repository.IFacturaDetalleCompraRepository;
import com.psicodidact.agendamiento.models.repository.IPreciosProductoRepository;
import com.psicodidact.agendamiento.models.repository.IRolRepository;

@Service
public class PreciosProductoServiceImpl  implements IPreciosProductoService{

	@Autowired
	private IPreciosProductoRepository iPreciosProducto;
	@Override
	public List<PreciosProducto> findAll() {
		// TODO Auto-generated method stub
		return (List<PreciosProducto>) iPreciosProducto.findAll();
	}

	@Override
	public Page<PreciosProducto> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public PreciosProducto findById(Long id) {
		return iPreciosProducto.findById(id).orElse(null);
	}

	@Override
	public PreciosProducto save(PreciosProducto producto) {
		return iPreciosProducto.save(producto);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
