package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.IUnidadEducativaRepository;

@Service
public class UnidadEducativaServiceImpl implements IUnidadEducativaService {

	@Autowired
	private IUnidadEducativaRepository iUnidadEducativa;

	@Override
	public List<UnidadEducativa> findAll() {
		return (List<UnidadEducativa>) iUnidadEducativa.findAll();
	}

	@Override
	public UnidadEducativa findById(Long id) {
		return (UnidadEducativa) iUnidadEducativa.findById(id).orElse(null);
	}

	@Override
	public UnidadEducativa save(UnidadEducativa unidadEducativa) {
		return iUnidadEducativa.save(unidadEducativa);
	}



	@Override
	public List<UnidadEducativa> findByNombreUnidadEducativaContainingIgnoreCase(String term) {
		return iUnidadEducativa.findByNombreUnidadEducativaContainingIgnoreCase(term);

	}



	

}