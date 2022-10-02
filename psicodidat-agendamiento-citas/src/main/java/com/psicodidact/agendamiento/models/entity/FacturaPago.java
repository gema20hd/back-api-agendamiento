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
@Table(name ="factura_pago")
public class FacturaPago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_pago")
	private Long idFacturaPago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pago")
	private Pago idPago;
	
	
	@Column(name="fecha_emision_pago")
	private Date fechaEmisionFacturaPago;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente idPacienteFacturaPago;


	@OneToMany(fetch = FetchType.LAZY,mappedBy="idfacturaPagoDetalleFacturaPago")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleFacturaPago> detalleFacturaPagofacturaPago;


	public Long getIdFacturaPago() {
		return idFacturaPago;
	}


	public void setIdFacturaPago(Long idFacturaPago) {
		this.idFacturaPago = idFacturaPago;
	}


	public Pago getIdPago() {
		return idPago;
	}


	public void setIdPago(Pago idPago) {
		this.idPago = idPago;
	}





	public List<DetalleFacturaPago> getDetalleFacturaPagofacturaPago() {
		return detalleFacturaPagofacturaPago;
	}


	public void setDetalleFacturaPagofacturaPago(List<DetalleFacturaPago> detalleFacturaPagofacturaPago) {
		this.detalleFacturaPagofacturaPago = detalleFacturaPagofacturaPago;
	}





	public Date getFechaEmisionFacturaPago() {
		return fechaEmisionFacturaPago;
	}


	public void setFechaEmisionFacturaPago(Date fechaEmisionFacturaPago) {
		this.fechaEmisionFacturaPago = fechaEmisionFacturaPago;
	}


	public Paciente getIdPacienteFacturaPago() {
		return idPacienteFacturaPago;
	}


	public void setIdPacienteFacturaPago(Paciente idPacienteFacturaPago) {
		this.idPacienteFacturaPago = idPacienteFacturaPago;
	}


	public FacturaPago() {
		
	}


	public FacturaPago(Long idFacturaPago, Pago idPago, Date fechaEmisionFacturaPago, Paciente idPacienteFacturaPago
		) {
		super();
		this.idFacturaPago = idFacturaPago;
		this.idPago = idPago;
		this.fechaEmisionFacturaPago = fechaEmisionFacturaPago;
		this.idPacienteFacturaPago = idPacienteFacturaPago;
		
	}
	
	
	
}
