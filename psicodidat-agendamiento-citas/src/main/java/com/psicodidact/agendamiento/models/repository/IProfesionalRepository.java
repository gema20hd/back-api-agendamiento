package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoSangre;



public interface IProfesionalRepository extends CrudRepository<Profesional, Long>{
	
	@Query("select p from Profesional p where p.identificacionProfesional=?1")
	public Profesional findByIdentification(String identification);
	
	@Query("select p from Profesional p where p.apellidoPaternoProfesional=?1")
	public Profesional findByLastName(String apellidoPaterno);
	
	@Query("select p from Profesional p where p.apellidoMaternoProfesional=?1")
	public Profesional findByMotherLastName(String apellidoMaternos);
	
	@Query("select g from  Genero g")
	public List<Genero> findAllGender();
	
	@Query("select e from EstadoCivil e")
	public List<EstadoCivil> findAllMaritalStatus();
	
	@Query("select d from Discapacidad d")
	public List<Discapacidad> findAllDisability();
	
	@Query("select ts from TipoSangre ts")
	public List<TipoSangre> findAllTypeBlood(); 

	@Query("select pp from ProfesionProfesional pp")
	public List<ProfesionProfesional> findAllProfessionProfessional();
	


}
