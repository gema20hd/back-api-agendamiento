package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoTrabajo;
import com.psicodidact.agendamiento.models.repository.ITipoDiscapacidadRepository;
import com.psicodidact.agendamiento.models.repository.ITipoTrabajoRepository;

@Service
public class TipoTrabajoServiceImpl implements ITipoTrabajoService{

	@Autowired
	private ITipoTrabajoRepository iTipoTrabajoRepository;
	
	@Override
	public List<TipoTrabajo> findAll() {
		return (List<TipoTrabajo>) iTipoTrabajoRepository.findAll();
	}

	@Override
	public TipoTrabajo findById(Long id) {
		// TODO Auto-generated method stub
		return iTipoTrabajoRepository.findById(id).get();
	}

	@Override
	public TipoTrabajo save(TipoTrabajo tipoTrabajo) {
		// TODO Auto-generated method stub
		return iTipoTrabajoRepository.save(tipoTrabajo);
	}

}
