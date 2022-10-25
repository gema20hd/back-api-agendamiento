package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.ICuentaRepository;

@Service
public class CuentaServiceImpl  implements ICuentaService {

	
	@Autowired
	private ICuentaRepository iCuenta;

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) iCuenta.findAll();
	}
	@Override
	public Page<Cuenta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cuenta findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cuenta save(Cuenta Cuenta) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}