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
	private IProfesionalRepository IProfesional;

	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findAll() {	
		return (List<Profesional>) this.IProfesional.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findById(Long id) {
		return this.IProfesional.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Profesional save(Profesional profesional) {
		return this.IProfesional.save(profesional);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	 this.IProfesional.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByIdentification(String identification) {
		return this.IProfesional.findByIdentification(identification);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByLastName(String apellidoPaterno) {
		return this.IProfesional.findByLastName(apellidoPaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findByMotherLastName(String apellidoMaterno) {
		return this.IProfesional.findByMotherLastName(apellidoMaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero> findAllGender() {
		return this.IProfesional.findAllGender();
	}

	@Override
	@Transactional(readOnly = true)
	public List<EstadoCivil> findAllMaritalStatus() {
		return this.IProfesional.findAllMaritalStatus();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Discapacidad> findAllDisability() {
		return this.IProfesional.findAllDisability();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoSangre> findAllTypeBlood() {
		return this.IProfesional.findAllTypeBlood();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesionProfesional> findAllProfessionProfessional() {
		return this.IProfesional.findAllProfessionProfessional();
	}

	
	
}
