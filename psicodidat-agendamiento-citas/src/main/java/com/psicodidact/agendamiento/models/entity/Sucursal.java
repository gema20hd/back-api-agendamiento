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
@Table(name ="sucursal")
public class Sucursal implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sucursal")
	private Long idSucursal;
	
	@Column(name="descripcion_sucursal")
	private String descripcionSucursal;

	public Long getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDescripcionSucursal() {
		return descripcionSucursal;
	}

	public void setDescripcionSucursal(String descripcionSucursal) {
		this.descripcionSucursal = descripcionSucursal;
	}


	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idSucursalOficina")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Oficina> oficinaSucursal;

	public List<Oficina> getOficinaSucursal() {
		return oficinaSucursal;
	}

	public void setOficinaSucursal(List<Oficina> oficinaSucursal) {
		this.oficinaSucursal = oficinaSucursal;
	}

	public Sucursal(Long idSucursal, String descripcionSucursal) {
		super();
		this.idSucursal = idSucursal;
		this.descripcionSucursal = descripcionSucursal;
	}
	
	public Sucursal() {

	}
	
	
}
