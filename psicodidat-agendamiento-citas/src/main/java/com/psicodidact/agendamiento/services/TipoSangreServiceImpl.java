package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.TipoSangre;
import com.psicodidact.agendamiento.models.repository.ITipoSangreRepository;

@Service
public class TipoSangreServiceImpl implements ITipoSangreService {
	
	@Autowired
	private ITipoSangreRepository tipoSangre;

	@Override
	public List<TipoSangre> findAll() {
		return  (List<TipoSangre>) tipoSangre.findAll();
	}

	@Override
	public TipoSangre findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoSangre save(TipoSangre tipoSangre) {
		// TODO Auto-generated method stub
		return null;
	}

}
