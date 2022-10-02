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
@Table(name ="servicio")
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servicio")
	private Long idServicio;
	
	@Column(name="descripcion_servicio")
	private String descripcionServicio;

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}


	

	@OneToMany(fetch = FetchType.LAZY,mappedBy="idServicioServicioCompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<ServicioCompra> ServicioCompraServicio;

	public List<ServicioCompra> getServicioCompraServicio() {
		return ServicioCompraServicio;
	}

	public void setServicioCompraServicio(List<ServicioCompra> servicioCompraServicio) {
		ServicioCompraServicio = servicioCompraServicio;
	}

	
	
	public Servicio(Long idServicio, String descripcionServicio) {
		super();
		this.idServicio = idServicio;
		this.descripcionServicio = descripcionServicio;
	}
	
	public Servicio() {

	}
	
}
