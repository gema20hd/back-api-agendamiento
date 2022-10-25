package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IGeneroRepository;

@Service
public class GeneroServiceImpl  implements IGeneroService {

	
	@Autowired
	private IGeneroRepository iGenero;

	@Override
	public List<Genero> findAll() {
		// TODO Auto-generated method stub
		return (List<Genero>) iGenero.findAll();
	}
	@Override
	public Page<Genero> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Genero findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Genero save(Genero Genero) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
