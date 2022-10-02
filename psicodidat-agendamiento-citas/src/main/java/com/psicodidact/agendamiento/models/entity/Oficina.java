package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="oficina")
public class Oficina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oficina")
	private Long idOficina;
	
	@Column(name="descripcion_oficina")
	private String descripcionOficina;
	
	@Column(name="color_oficina")
	private String colorOficina;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sucursal")
	private Sucursal idSucursalOficina;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idOficinaCita")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cita> citaOficina;


	public Long getIdOficina() {
		return idOficina;
	}


	public void setIdOficina(Long idOficina) {
		this.idOficina = idOficina;
	}


	public String getDescripcionOficina() {
		return descripcionOficina;
	}


	public void setDescripcionOficina(String descripcionOficina) {
		this.descripcionOficina = descripcionOficina;
	}


	public String getColorOficina() {
		return colorOficina;
	}


	public void setColorOficina(String colorOficina) {
		this.colorOficina = colorOficina;
	}


	public Sucursal getIdSucursalOficina() {
		return idSucursalOficina;
	}


	public void setIdSucursalOficina(Sucursal idSucursalOficina) {
		this.idSucursalOficina = idSucursalOficina;
	}


	public List<Cita> getCitaOficina() {
		return citaOficina;
	}


	public void setCitaOficina(List<Cita> citaOficina) {
		this.citaOficina = citaOficina;
	}


	public Oficina(Long idOficina, String descripcionOficina, String colorOficina, Sucursal idSucursalOficina,
			List<Cita> citaOficina) {
		super();
		this.idOficina = idOficina;
		this.descripcionOficina = descripcionOficina;
		this.colorOficina = colorOficina;
		this.idSucursalOficina = idSucursalOficina;
		this.citaOficina = citaOficina;
	}
	
	public Oficina() {

	}
	
	
}
