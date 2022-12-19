package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.psicodidact.agendamiento.models.entity.HorarioActividad;
import com.psicodidact.agendamiento.models.repository.IHorarioActividadRepository;


@Service
public class HorarioActividadServiceImpl implements IHorarioActividadService {

	@Autowired
	private IHorarioActividadRepository iHorarioActividad;
	
	@Override
	public List<HorarioActividad> findAll() {
		// TODO Auto-generated method stub
		return (List<HorarioActividad>) iHorarioActividad.findAll();
	}

	@Override
	public Page<HorarioActividad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HorarioActividad findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HorarioActividad save(HorarioActividad horarioActividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
