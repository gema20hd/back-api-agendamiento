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
@Table(name ="especialidad")
public class Especialidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidad")
	private Long idEspecialidad;
	
	@Column(name="descripcion_especialidad")
	private String descripcionEspecialidad;

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}


	

	@OneToMany(fetch = FetchType.LAZY,mappedBy="idEspecialidadServicioCompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<ServicioCompra> servicioCompraEspecialidad;

	public List<ServicioCompra> getServicioCompraEspecialidad() {
		return servicioCompraEspecialidad;
	}

	public void setServicioCompraEspecialidad(List<ServicioCompra> servicioCompraEspecialidad) {
		this.servicioCompraEspecialidad = servicioCompraEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

	public Especialidad(Long idEspecialidad, String descripcionEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
	
	public Especialidad() {

	}
	
	
	
}
