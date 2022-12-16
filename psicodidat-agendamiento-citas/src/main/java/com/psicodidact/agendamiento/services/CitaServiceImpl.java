package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Actividad;
import com.psicodidact.agendamiento.models.entity.Cita;
import com.psicodidact.agendamiento.models.repository.ICitaRepository;
@Service
public class CitaServiceImpl  implements ICitaService{


	@Autowired
	private ICitaRepository icita;
	
	@Override
	public List<Cita> findAll() {
		// TODO Auto-generated method stub
		return (List<Cita>) icita.findAll();
	}

	@Override
	public Page<Cita> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita save(Cita cita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
