package com.psicodidact.agendamiento.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoSangre;


public interface IProfesionalRepository extends CrudRepository<Profesional, Long>{
	
	@Query("select p from Profesional p where p.identificacionProfesional=?1")
	public Profesional findByIdentification(String identification);
	
	@Query("select p from Profesional p where p.apellidoPaternoProfesional=?1")
	public Profesional findByLastName(String apellidoPaterno);
	
	@Query("select p from Profesional p where p.apellidoMaternoProfesional=?1")
	public Profesional findByMotherLastName(String apellidoMaternos);
	
	@Query("SELECT * FROM Genero")
	public List<Genero> findAllGender();
	
	@Query("SELECT * FROM EstadoCivil")
	public List<EstadoCivil> findAllMaritalStatus();
	
	@Query("SELECT * FROM Discapacidad")
	public List<Discapacidad> findAllDisability();
	
	@Query("SELECT * FROM TipoSangre")
	public List<TipoSangre> findAllTipoSangre(); 

	@Query("SELECT * FROM ProfesionProfesional")
	public List<ProfesionProfesional> findAllProfessionProfessional();
	
	@Query("SELECT * FROM TipoCuenta")
	public List<TipoCuenta> findAllAccounType();
	
	@Query("SELECT * FROM Banco")
	public List<Banco> findAllBank();
	
	@Query("SELECT * FROM TipoDiscapacidad")
	public List<TipoDiscapacidad> findAllTypeDisability();
}
