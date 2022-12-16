package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Antecedente;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IAntecedentesRepository;

@Service
public class AntecedentesServiceImpl  implements IAntecedentesService {

	
	@Autowired
	private IAntecedentesRepository iAntecedente;

	@Override
	public List<Antecedente> findAll() {
		// TODO Auto-generated method stub
		return (List<Antecedente>) iAntecedente.findAll();
	}
	@Override
	public Page<Antecedente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Antecedente findById(Long id) {
		// TODO Auto-generated method stub
		return iAntecedente.findById(id).get();
	}
	@Override
	public Antecedente save(Antecedente antecedente) {
		return iAntecedente.save(antecedente);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Antecedente actualizar(Antecedente antecedentes) {
		// TODO Auto-generated method stub
		return iAntecedente.save(antecedentes);
	}


}
