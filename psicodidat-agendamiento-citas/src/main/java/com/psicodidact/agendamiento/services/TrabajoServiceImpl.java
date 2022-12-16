package com.psicodidact.agendamiento.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Trabajo;
import com.psicodidact.agendamiento.models.entity.UnidadEducativa;
import com.psicodidact.agendamiento.models.repository.ITrabajoRepository;

@Service
public class TrabajoServiceImpl  implements ITrabajoService{
	

	@Autowired
	private ITrabajoRepository itrabajo;

	@Override
	public List<Trabajo> findAll() {
		return (List<Trabajo>) itrabajo.findAll();
	}

	@Override
	public Trabajo findById(Long id) {
		return itrabajo.findById(id).get();	
     }
     
     
	@Override
	public Trabajo save(Trabajo trabajo) {
		// TODO Auto-generated method stub
		return itrabajo.save(trabajo);
	}

	@Override
	public Trabajo actualizar(Trabajo trabajo) {
		// TODO Auto-generated method stub
		return itrabajo.save(trabajo);
	}
	

}
