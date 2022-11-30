package com.psicodidact.agendamiento.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.psicodidact.agendamiento.models.entity.Banco;
import com.psicodidact.agendamiento.models.entity.Discapacidad;
import com.psicodidact.agendamiento.models.entity.EstadoCivil;
import com.psicodidact.agendamiento.models.entity.Genero;
import com.psicodidact.agendamiento.models.entity.ProfesionProfesional;
import com.psicodidact.agendamiento.models.entity.Profesional;
import com.psicodidact.agendamiento.models.entity.TipoCuenta;
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoSangre;



public interface IProfesionalService {

	public List<Profesional> findAll();
	
	public Profesional findById(Long id);
	
	public Profesional save(Profesional profesional);
	
	public void delete(Long id);
	
	public Profesional findByIdentification(String identification);
	
	public List<Profesional> findByLastName(String apellidoPaterno);
	
	public List<Profesional> findByMotherLastName(String apellidoMaterno);
	
	public List<Genero> findAllGender();
	
	public List<EstadoCivil> findAllMaritalStatus();
	
	public List<Discapacidad> findAllDisability();
	
	public List<TipoDiscapacidad> findAllTypeDisability();
	
	public List<TipoSangre> findAllTypeBlood(); 

	public List<ProfesionProfesional> findAllProfessionProfessional();
	
	//public List<Banco> findBydescripcionBancoContainingIgnoreCase(String term);
	
	/*public List<Banco> findAllBank(); 
	
	public Banco findByIdBank(Long id);
	
	public Banco findByIdBill(Long id);
	
	public Banco save(Banco banco);
	*/
	
	


}
