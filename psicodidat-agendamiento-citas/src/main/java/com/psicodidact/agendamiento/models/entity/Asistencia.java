package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="asistencia")
public class Asistencia  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asistencia")
	private Long idAsistencia;
	
	@Column(name="estado_asistencia")
	private boolean estadoAsistencia;
	
	@Column(name="estado_reagendado")
	private int estadoReagendado;
	
	@Column(name="estado_justificado")
	private int estadoJutificado;

	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public boolean isEstadoAsistencia() {
		return estadoAsistencia;
	}

	public void setEstadoAsistencia(boolean estadoAsistencia) {
		this.estadoAsistencia = estadoAsistencia;
	}

	public int getEstadoReagendado() {
		return estadoReagendado;
	}

	public void setEstadoReagendado(int estadoReagendado) {
		this.estadoReagendado = estadoReagendado;
	}

	public int getEstadoJutificado() {
		return estadoJutificado;
	}

	public void setEstadoJutificado(int estadoJutificado) {
		this.estadoJutificado = estadoJutificado;
	}

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idAsistenciaCita")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cita> citaAsistencia;

	public List<Cita> getCitaAsistencia() {
		return citaAsistencia;
	}

	public void setCitaAsistencia(List<Cita> citaAsistencia) {
		this.citaAsistencia = citaAsistencia;
	}

	public Asistencia(Long idAsistencia, boolean estadoAsistencia, int estadoReagendado, int estadoJutificado) {
		super();
		this.idAsistencia = idAsistencia;
		this.estadoAsistencia = estadoAsistencia;
		this.estadoReagendado = estadoReagendado;
		this.estadoJutificado = estadoJutificado;
	}
	
	public Asistencia() {

	}
	
}
