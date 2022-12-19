package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.psicodidact.agendamiento.models.entity.Paciente;



public interface IPacienteService {

	public List<Paciente> findAll();
	
	public Page<Paciente> findAll(Pageable pageable);
	
	public Paciente findById(Long id);
	
	public Paciente save(Paciente Paciente);
	
	public void delete(Long id);
	
    public Paciente actualizar(Paciente paciente);
	
	Paciente buscarPorCedulaPaciente(String identificacionPaciente);
	
	List<Paciente> buscarPacienteByApellidoPaterno(String apellidoPaterno);

}