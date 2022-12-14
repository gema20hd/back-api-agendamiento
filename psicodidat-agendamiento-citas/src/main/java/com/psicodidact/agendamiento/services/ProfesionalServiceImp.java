package com.psicodidact.agendamiento.services;

import java.text.ParseException;
import java.util.Date;
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
import com.psicodidact.agendamiento.models.entity.TipoDiscapacidad;
import com.psicodidact.agendamiento.models.entity.TipoSangre;
import com.psicodidact.agendamiento.models.repository.IBancoRepository;
import com.psicodidact.agendamiento.models.repository.ICuentaRepository;
import com.psicodidact.agendamiento.models.repository.IDiscapacidadRepository;
import com.psicodidact.agendamiento.models.repository.IProfesionalRepository;

@Service
public class ProfesionalServiceImp  implements IProfesionalService {

	
	@Autowired
	private IProfesionalRepository IProfesional;

	
	@Autowired
	private CuentaServiceImpl iCuenta;

	@Autowired
	private DiscapacidadServiceImpl idiscapacidad;
	
	@Autowired
	private IBancoRepository iBanco;

	
	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findAll() {	
		return (List<Profesional>) this.IProfesional.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesional findById(Long id)  {
		Profesional profesionalAux = null;
	
		    profesionalAux = this.IProfesional.findByIdProfesional(id);
			profesionalAux.setEdadProfesional(profesionalAux.calcularEdad(profesionalAux.getFechaNacimientoProfesional()));
			profesionalAux.setFechaNacimientoProfesional(profesionalAux.getFechaNacimientoProfesional());
		
		
		return profesionalAux;
	}

	@Override
	@Transactional
	public Profesional save(Profesional profesional) {
		Profesional profesionalAux =null;
		try {
			profesionalAux =this.IProfesional.save(profesional);
			return profesionalAux;
		}catch (Exception e) {
			iCuenta.delete(profesional.getCuenta().getIdCuenta());
			idiscapacidad.delete(profesional.getDiscapacidad().getIdDiscapacidad());
		return null;
		}
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
	 this.IProfesional.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findByIdentificacionProfesionalContainingIgnoreCase(String identification) {
		return this.IProfesional.findByIdentificacionProfesionalContainingIgnoreCase(identification);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesional>findByApellidoPaternoProfesionalContainingIgnoreCase(String apellidoPaterno) {
		return  this.IProfesional.findByApellidoPaternoProfesionalContainingIgnoreCase(apellidoPaterno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesional> findByApellidoMaternoProfesionalContainingIgnoreCase(String apellidoMaterno) {
		return  this.IProfesional.findByApellidoMaternoProfesionalContainingIgnoreCase(apellidoMaterno);
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

	@Override
	@Transactional(readOnly = true)
	public List<TipoDiscapacidad> findAllTypeDisability() {
		return this.IProfesional.findAllTypeDisability();
	}

	@Override
	public Profesional findByCorreo(String correo) {
		// TODO Auto-generated method stub
		return this.IProfesional.findByCorreo(correo);
	}

	
}
