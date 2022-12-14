package com.psicodidact.agendamiento.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;

import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;


import com.psicodidact.agendamiento.models.entity.TipoSangre;



public interface IProfesionalRepository extends CrudRepository<Profesional, Long>{
	
	@Query("select p from Profesional p where p.identificacionProfesional=?1")
	public Profesional findByIdentification(String identification);
	
	@Query("select p from Profesional p where p.apellidoPaternoProfesional like %?1%")
	public Profesional findByLastName(String apellidoPaterno);
	
	@Query("select p from Profesional p where p.apellidoMaternoProfesional like %?1%")
	public Profesional findByMotherLastName(String apellidoMaterno);
	
	public List<Profesional> findByIdentificacionProfesionalContainingIgnoreCase(String term); // gema 

	public List<Profesional> findByApellidoPaternoProfesionalContainingIgnoreCase(String term);
	
	public List<Profesional> findByApellidoMaternoProfesionalContainingIgnoreCase(String term);
	
	@Query("select g from  Genero g")
	public List<Genero> findAllGender();
	
	@Query("select e from EstadoCivil e")
	public List<EstadoCivil> findAllMaritalStatus();
	
	@Query("select td from TipoDiscapacidad td")
	public List<TipoDiscapacidad> findAllTypeDisability();
	
	@Query("select d from Discapacidad d")
	public List<Discapacidad> findAllDisability();
	
	@Query("select ts from TipoSangre ts")
	public List<TipoSangre> findAllTypeBlood(); 

	@Query("select pp from ProfesionProfesional pp")
	public List<ProfesionProfesional> findAllProfessionProfessional();
	
	@Query("select p from Profesional p where p.correoElectronicoProfesional=?1")
	public Profesional findByCorreo(String correo);
	
	@Query("select p from Profesional p where p.idProfesional=?1")
	public Profesional findByIdProfesional(Long IdProfesional);
	

}
