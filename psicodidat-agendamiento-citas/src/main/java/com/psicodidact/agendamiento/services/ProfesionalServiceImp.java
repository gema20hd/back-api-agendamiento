package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoSangre;
import com.psicodidact.agendamiento.models.repository.IProfesionalRepository;

@Service
public class ProfesionalServiceImp  implements IProfesionalService {

	
	@Autowired
	private IProfesionalRepository profesional;

	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findAll() {	
		return (List<Profesional>) this.profesional.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findById(Long id) {
		return this.profesional.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Profesional save(Profesional profesional) {
		return this.profesional.save(profesional);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	 this.profesional.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByIdentification(String identification) {
		return this.profesional.findByIdentification(identification);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByLastName(String apellidoPaterno) {
		return this.profesional.findByLastName(apellidoPaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByMotherLastName(String apellidoMaterno) {
		return this.findByMotherLastName(apellidoMaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero> findAllGender() {
		return this.profesional.findAllGender();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoCivil> findAllMaritalStatus() {
		return this.findAllMaritalStatus();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Discapacidad> findAllDisability() {
		return this.findAllDisability();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoSangre> findAllTypeBlood() {
		return this.findAllTypeBlood();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesionProfesional> findAllProfessionProfessional() {
		return this.findAllProfessionProfessional();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoCuenta> findAllAccounType() {
		return this.profesional.findAllAccounType();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Banco> findAllBank() {
		return this.profesional.findAllBank();
	}


	@Override
	@Transactional(readOnly = true)
	public List<TipoDiscapacidad> findAllTypeDisability() {
		return this.profesional.findAllTypeDisability();
	}


	
}
