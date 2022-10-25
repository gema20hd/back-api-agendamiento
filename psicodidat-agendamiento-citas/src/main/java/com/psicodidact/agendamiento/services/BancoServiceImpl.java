package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IBancoRepository;

@Service
public class BancoServiceImpl  implements IBancoService {

	
	@Autowired
	private IBancoRepository iBanco;

	@Override
	public List<Banco> findAll() {
		// TODO Auto-generated method stub
		return (List<Banco>) iBanco.findAll();
	}
	@Override
	public Page<Banco> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Banco findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Banco save(Banco Banco) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}