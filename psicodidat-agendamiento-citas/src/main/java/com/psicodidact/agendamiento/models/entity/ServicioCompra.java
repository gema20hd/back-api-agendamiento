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
@Table(name ="servicio_compra")
public class ServicioCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servicio_compra")
	private Long idServicioCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_especialidad")
	private Especialidad idEspecialidadServicioCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_servicio")
	private Servicio idServicioServicioCompra;
	
	@Column(name="descripcion_servicio_compra")
	private String descripcionServicioCompra;
	
	@Column(name="costo_servicio_compra")
	private float costoServicioCompra;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idServicioDetalleCompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleCompra> detalleCompraServicioCompra;

	public Long getIdServicioCompra() {
		return idServicioCompra;
	}

	public void setIdServicioCompra(Long idServicioCompra) {
		this.idServicioCompra = idServicioCompra;
	}

	public Especialidad getIdEspecialidadServicioCompra() {
		return idEspecialidadServicioCompra;
	}

	public void setIdEspecialidadServicioCompra(Especialidad idEspecialidadServicioCompra) {
		this.idEspecialidadServicioCompra = idEspecialidadServicioCompra;
	}

	public Servicio getIdServicioServicioCompra() {
		return idServicioServicioCompra;
	}

	public void setIdServicioServicioCompra(Servicio idServicioServicioCompra) {
		this.idServicioServicioCompra = idServicioServicioCompra;
	}

	public String getDescripcionServicioCompra() {
		return descripcionServicioCompra;
	}

	public void setDescripcionServicioCompra(String descripcionServicioCompra) {
		this.descripcionServicioCompra = descripcionServicioCompra;
	}

	public float getCostoServicioCompra() {
		return costoServicioCompra;
	}

	public void setCostoServicioCompra(float costoServicioCompra) {
		this.costoServicioCompra = costoServicioCompra;
	}

	public List<DetalleCompra> getDetalleCompraServicioCompra() {
		return detalleCompraServicioCompra;
	}

	public void setDetalleCompraServicioCompra(List<DetalleCompra> detalleCompraServicioCompra) {
		this.detalleCompraServicioCompra = detalleCompraServicioCompra;
	}

	public ServicioCompra(Long idServicioCompra, Especialidad idEspecialidadServicioCompra,
			Servicio idServicioServicioCompra, String descripcionServicioCompra, float costoServicioCompra,
			List<DetalleCompra> detalleCompraServicioCompra) {
		super();
		this.idServicioCompra = idServicioCompra;
		this.idEspecialidadServicioCompra = idEspecialidadServicioCompra;
		this.idServicioServicioCompra = idServicioServicioCompra;
		this.descripcionServicioCompra = descripcionServicioCompra;
		this.costoServicioCompra = costoServicioCompra;
		this.detalleCompraServicioCompra = detalleCompraServicioCompra;
	}
	
	public ServicioCompra() {

	}

	
	
	
}
