package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name ="compra")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Long idCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente idPacienteCompra;
	
	@Column(name="fecha_emision_compra")
	private Date fechaEmisionCompra;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idCompraDetalleCompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleCompra> detalleCompraCompra;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Paciente getIdPacienteCompra() {
		return idPacienteCompra;
	}

	public void setIdPacienteCompra(Paciente idPacienteCompra) {
		this.idPacienteCompra = idPacienteCompra;
	}

	public Date getFechaEmisionCompra() {
		return fechaEmisionCompra;
	}

	public void setFechaEmisionCompra(Date fechaEmisionCompra) {
		this.fechaEmisionCompra = fechaEmisionCompra;
	}

	public List<DetalleCompra> getDetalleCompraCompra() {
		return detalleCompraCompra;
	}

	public void setDetalleCompraCompra(List<DetalleCompra> detalleCompraCompra) {
		this.detalleCompraCompra = detalleCompraCompra;
	}

	public Compra(Long idCompra, Paciente idPacienteCompra, Date fechaEmisionCompra) {
		super();
		this.idCompra = idCompra;
		this.idPacienteCompra = idPacienteCompra;
		this.fechaEmisionCompra = fechaEmisionCompra;

	}
	
	public Compra() {

	}
	
	
	
	

}
