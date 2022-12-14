package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psicodidact.agendamiento.models.entity.Paciente;
import com.psicodidact.agendamiento.models.entity.Profesional;


public interface IPacienteRepository extends CrudRepository<Paciente, Long>{
	
	Paciente  findByIdentificacionPaciente(String identificacionPaciente);
	
	@Query("from Paciente p where upper(p.apellidoPaternoPaciente) like upper(concat(:apellidoPaternoPaciente,'%'))")
	List<Paciente>  findByApellidoPaternoPaciente(@Param("apellidoPaternoPaciente") String apellidoPaternoPaciente);
	
	public List<Paciente> findByIdentificacionPacienteContainingIgnoreCase(String term);

	public List<Paciente> findByApellidoPaternoPacienteContainingIgnoreCase(String term);
}
