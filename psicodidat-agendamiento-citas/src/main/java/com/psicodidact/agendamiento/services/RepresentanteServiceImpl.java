package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Representante;
import com.psicodidact.agendamiento.models.repository.IRepresentanteRepository;

@Service
public class RepresentanteServiceImpl  implements IRepresentanteService{

	@Autowired
	private IRepresentanteRepository representanteRepository;
	
	@Override
	public List<Representante> findAll() {
		return (List<Representante>) representanteRepository.findAll();
	}

	@Override
	public Representante findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Representante save(Representante representate) {
		// TODO Auto-generated method stub
		return null;
	}

}
