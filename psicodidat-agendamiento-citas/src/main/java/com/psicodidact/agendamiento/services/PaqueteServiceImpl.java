package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Paquete;
import com.psicodidact.agendamiento.models.entity.Rol;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.IFacturaCompraRepository;
import com.psicodidact.agendamiento.models.repository.IPaqueteRepository;
import com.psicodidact.agendamiento.models.repository.IRolRepository;

@Service
public class PaqueteServiceImpl  implements IPaqueteService{
	
	
	@Autowired
	private IPaqueteRepository iPaquete;

	@Override
	public List<Paquete> findAll() {
		return (List<Paquete>) iPaquete.findAll();
	}

	@Override
	public Page<Paquete> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public Paquete findById(Long id) {
		return iPaquete.findById(id).orElse(null);
	}

	@Override
	public Paquete save(Paquete paquete) {
		return iPaquete.save(paquete);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
