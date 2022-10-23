package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.NivelEducacionParalelo;



public interface INivelEducacionService {

	public List<NivelEducacionParalelo> findAll();
	
	public Page<NivelEducacionParalelo> findAll(Pageable pageable);
	
	public NivelEducacionParalelo findById(Long id);
	
	public NivelEducacionParalelo save(NivelEducacionParalelo NivelEducacion);
	
	public void delete(Long id);
	


}