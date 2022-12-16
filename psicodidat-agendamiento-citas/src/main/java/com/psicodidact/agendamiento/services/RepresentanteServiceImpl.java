package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Representante;
import com.psicodidact.agendamiento.models.repository.IRepresentanteRepository;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RepresentanteServiceImpl  implements IRepresentanteService{

	@Autowired
	private IRepresentanteRepository representanteRepository;
	
	@Override
	public List<Representante> findAll() {
		return (List<Representante>) representanteRepository.findAll();
	}

	@Override
	public Representante findById(Long id) {
		// TODO Auto-generated method stub
		return representanteRepository.findById(id).get();
	}

	@Override
	public Representante save(Representante representate) {
		return representanteRepository.save(representate);
	}
	@Override
	@Transactional
	public void eliminar(Long id) {
		Representante representante= new Representante();
		representante=representanteRepository.findById(id).get();
		representanteRepository.delete(representante);
		
	}

	@Override
	@Transactional
	public Representante actualizar(Representante representate) {
		return representanteRepository.save(representate);
	}
	


	@Override
	@Transactional
	public Representante buscarPorCedulaRepresentante(String identificacionRepresentante) {
		return representanteRepository.findByIdentificacionRepresentante(identificacionRepresentante);
	}
	
	

}
