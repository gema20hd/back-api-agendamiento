package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.Evaluacion;
import com.psicodidact.agendamiento.models.repository.IEvaluacionRepository;



@Service
public class EvaluacionServiceImpl implements IEvaluacionService {

	
	@Autowired
	private IEvaluacionRepository ievaluacion;
	
	@Override
	public List<Evaluacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Evaluacion>) ievaluacion.findAll();
	}

	@Override
	public Page<Evaluacion> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluacion findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluacion save(Evaluacion evaluacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
