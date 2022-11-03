package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Profesional findByIdentification(String identification) {
		return this.profesional.findByIdentification(identification);
	}

	@Override
	public Profesional findByLastName(String apellidoPaterno) {
		return this.profesional.findByLastName(apellidoPaterno);
	}

	@Override
	public Profesional findByMotherLastName(String apellidoMaterno) {
		return this.findByMotherLastName(apellidoMaterno);
	}

	@Override
	public List<Genero> findAllGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoCivil> findAllMaritalStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discapacidad> findAllDisability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoSangre> findAllTipoSangre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfesionProfesional> findAllProfessionProfessional() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoCuenta> findAllAccounType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoCuenta> findAllBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDiscapacidad> findAllTypeDisability() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
