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
@Table(name ="pago")
public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago")
	private Long idPago;
	
	@Column(name="tipo_pago")
	private String tipoPago;
	
	@Column(name="numero_transferencia_pago")
	private String numeroTransferenciaPago;
	
	@Column(name="numero_transaccion_pago")
	private String numeroTransaccionPago;
	
	@Column(name="tipo_tarjeta_pago")
	private String tipoTarjetaPago;
	
	@Column(name="numero_cheque_pago")
	private String numeroChequePago;
	
	@Column(name="numero_recibo_pago")
	private String numeroReciboPago;
	
	@Column(name="numero_factura_pago")
	private String numeroFacturaPago;
	
	@Column(name="nombre_banco_pago")
	private String nombreBancoPago;

	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getNumeroTransferenciaPago() {
		return numeroTransferenciaPago;
	}

	public void setNumeroTransferenciaPago(String numeroTransferenciaPago) {
		this.numeroTransferenciaPago = numeroTransferenciaPago;
	}

	public String getNumeroTransaccionPago() {
		return numeroTransaccionPago;
	}

	public void setNumeroTransaccionPago(String numeroTransaccionPago) {
		this.numeroTransaccionPago = numeroTransaccionPago;
	}

	public String getTipoTarjetaPago() {
		return tipoTarjetaPago;
	}

	public void setTipoTarjetaPago(String tipoTarjetaPago) {
		this.tipoTarjetaPago = tipoTarjetaPago;
	}

	public String getNumeroChequePago() {
		return numeroChequePago;
	}

	public void setNumeroChequePago(String numeroChequePago) {
		this.numeroChequePago = numeroChequePago;
	}

	public String getNumeroReciboPago() {
		return numeroReciboPago;
	}

	public void setNumeroReciboPago(String numeroReciboPago) {
		this.numeroReciboPago = numeroReciboPago;
	}

	public String getNumeroFacturaPago() {
		return numeroFacturaPago;
	}

	public void setNumeroFacturaPago(String numeroFacturaPago) {
		this.numeroFacturaPago = numeroFacturaPago;
	}

	public String getNombreBancoPago() {
		return nombreBancoPago;
	}

	public void setNombreBancoPago(String nombreBancoPago) {
		this.nombreBancoPago = nombreBancoPago;
	}

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idPago")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<FacturaPago> facturaPagoPago;

	public List<FacturaPago> getFacturaPagoPago() {
		return facturaPagoPago;
	}

	public void setFacturaPagoPago(List<FacturaPago> facturaPagoPago) {
		this.facturaPagoPago = facturaPagoPago;
	}
	
	
	
	public Pago(Long idPago, String tipoPago, String numeroTransferenciaPago, String numeroTransaccionPago,
			String tipoTarjetaPago, String numeroChequePago, String numeroReciboPago, String numeroFacturaPago,
			String nombreBancoPago) {
		super();
		this.idPago = idPago;
		this.tipoPago = tipoPago;
		this.numeroTransferenciaPago = numeroTransferenciaPago;
		this.numeroTransaccionPago = numeroTransaccionPago;
		this.tipoTarjetaPago = tipoTarjetaPago;
		this.numeroChequePago = numeroChequePago;
		this.numeroReciboPago = numeroReciboPago;
		this.numeroFacturaPago = numeroFacturaPago;
		this.nombreBancoPago = nombreBancoPago;
	}
	
	public Pago() {

	}
	



	
	
	
	
}
