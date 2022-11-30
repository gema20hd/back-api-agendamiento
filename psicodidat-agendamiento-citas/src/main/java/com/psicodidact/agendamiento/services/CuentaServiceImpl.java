package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Cuenta;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IBancoRepository;
import com.psicodidact.agendamiento.models.repository.ICuentaRepository;

@Service
public class CuentaServiceImpl  implements ICuentaService {

	
	@Autowired
	private ICuentaRepository iCuenta;
	
	@Autowired
	private IBancoRepository iBanco;

	@Override
	public List<Cuenta> findAll() {
		return (List<Cuenta>) iCuenta.findAll();
	}

	@Override
	public Cuenta findById(Long id) {
		return (Cuenta) iCuenta.findById(id).orElse(null);
	}

	@Override
	public Cuenta save(Cuenta cuenta) {
		return iCuenta.save(cuenta);
	}

	@Override
	public void delete(Long id) {
		iCuenta.deleteById(id);
	}

	@Override
	public List<TipoCuenta> findAllAccounType() {
		return iCuenta.findAllAccounType();
	}

	@Override
	public List<Banco> findAllBank() {
		return iCuenta.findAllBank();
	}

	@Override
	public List<Banco> findByDescripcionBancoContainingIgnoreCase(String term) {
		return iBanco.findByDescripcionBancoContainingIgnoreCase(term);
	}

	@Override
	public Banco findByBank(Long id) {
		return iBanco.findById(id).orElse(null);
	}





	

	

}