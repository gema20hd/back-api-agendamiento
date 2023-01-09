package com.psicodidact.agendamiento.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.psicodidact.agendamiento.models.entity.Paciente;
import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.models.repository.IPacienteRepository;

@Service
public class PacienteServiceImpl  implements IPacienteService {

	
	@Autowired
	private IPacienteRepository iPaciente;

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>) iPaciente.findAll();
	}
	@Override
	public Page<Paciente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Paciente findById(Long id) {
		// TODO Auto-generated method stub
		return iPaciente.findById(id).get();
	}
	@Override
	public Paciente save(Paciente paciente) {
		// TODO Auto-generated method stub
		return iPaciente.save(paciente);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Transactional
	public Paciente actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		return iPaciente.save(paciente);
	}
	
	
	@Override
	public Paciente buscarPorCedulaPaciente(String identificacionPaciente) {
		// TODO Auto-generated method stub
		return iPaciente.findByIdentificacionPaciente(identificacionPaciente);
	}
	
	
	@Override
	public List<Paciente> buscarPacienteByApellidoPaterno(String apellidoPaterno) {
		// TODO Auto-generated method stub
		return iPaciente.findByApellidoPaternoPaciente(apellidoPaterno);
	}
	@Override
	public List<Paciente> findByIdentificacionPacienteContainingIgnoreCase(String term) {
		// TODO Auto-generated method stub
		return iPaciente.findByIdentificacionPacienteContainingIgnoreCase(term);
	}
	@Override
	public List<Paciente> findByApellidoPaternoPacienteContainingIgnoreCase(String term) {
		// TODO Auto-generated method stub
		return iPaciente.findByApellidoPaternoPacienteContainingIgnoreCase(term);
	}


}