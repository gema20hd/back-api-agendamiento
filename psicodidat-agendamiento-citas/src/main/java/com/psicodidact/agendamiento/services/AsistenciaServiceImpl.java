package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Asistencia;
import com.psicodidact.agendamiento.models.repository.IAsistenciaRepository;
@Service
public class AsistenciaServiceImpl implements IAsistenciaService{

	@Autowired
	private IAsistenciaRepository iasistencia;
	
	@Override
	public List<Asistencia> findAll() {
		// TODO Auto-generated method stub
		return  (List<Asistencia>) iasistencia.findAll();
	}

	@Override
	public Page<Asistencia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asistencia findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asistencia save(Asistencia Actividad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
