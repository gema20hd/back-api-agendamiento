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
@Table(name ="sub_servicio")
public class SubServicio implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sub_servicio")
	private Long idSubServicio;
	
	@Column(name="descripcion_sub_servicio")
	private String descripcionSubServicio;

	public Long getIdSubServicio() {
		return idSubServicio;
	}

	public void setIdSubServicio(Long idSubServicio) {
		this.idSubServicio = idSubServicio;
	}

	public String getDescripcionSubServicio() {
		return descripcionSubServicio;
	}

	public void setDescripcionSubServicio(String descripcionSubServicio) {
		this.descripcionSubServicio = descripcionSubServicio;
	}


	@OneToMany(fetch = FetchType.LAZY,mappedBy="idSubServicioCita")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cita> subServicioCita;


	
	public List<Cita> getSubServicioCita() {
		return subServicioCita;
	}

	public void setSubServicioCita(List<Cita> subServicioCita) {
		this.subServicioCita = subServicioCita;
	}

	public SubServicio(Long idSubServicio, String descripcionSubServicio) {
		super();
		this.idSubServicio = idSubServicio;
		this.descripcionSubServicio = descripcionSubServicio;
	}
	

	public SubServicio() {

	}
	
	

	
}
