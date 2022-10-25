package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IEstadoCivilRepository;

@Service
public class EstadoCivilServiceImpl  implements IEstadoCivilService {

	
	@Autowired
	private IEstadoCivilRepository iEstadoCivil;

	@Override
	public List<EstadoCivil> findAll() {
		// TODO Auto-generated method stub
		return (List<EstadoCivil>) iEstadoCivil.findAll();
	}
	@Override
	public Page<EstadoCivil> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EstadoCivil findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EstadoCivil save(EstadoCivil EstadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}