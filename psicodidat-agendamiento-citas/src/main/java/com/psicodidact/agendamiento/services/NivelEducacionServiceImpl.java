package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.NivelEducacionParalelo;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.INivelEducacionParaleloRepository;

@Service
public class NivelEducacionServiceImpl  implements INivelEducacionService {

	
	@Autowired
	private INivelEducacionParaleloRepository iNivelEducacionParalelo;

	@Override
	public List<NivelEducacionParalelo> findAll() {
		// TODO Auto-generated method stub
		return (List<NivelEducacionParalelo>) iNivelEducacionParalelo.findAll();
	}
	@Override
	public Page<NivelEducacionParalelo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public NivelEducacionParalelo findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public NivelEducacionParalelo save(NivelEducacionParalelo NivelEducacionParalelo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}

