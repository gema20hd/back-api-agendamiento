package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name ="detalle_factura_pago")
public class DetalleFacturaPago implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_factura_pago")
	private Long idDetalleFacturaPago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_factura_pago")
	private FacturaPago idfacturaPagoDetalleFacturaPago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_detalle_compra")
	private DetalleCompra idDetalleCompraDetalleFacturaPago;
	
	@Column(name="unidad_detalle_factura_pago")
	private int unidadDetalleFacturaPago;
	
	@Column(name="valor_pagar_detalle_factura_pago")
	private float valorPagarDetalleFacturaPago;

	public Long getIdDetalleFacturaPago() {
		return idDetalleFacturaPago;
	}

	public void setIdDetalleFacturaPago(Long idDetalleFacturaPago) {
		this.idDetalleFacturaPago = idDetalleFacturaPago;
	}

	public FacturaPago getIdfacturaPagoDetalleFacturaPago() {
		return idfacturaPagoDetalleFacturaPago;
	}

	public void setIdfacturaPagoDetalleFacturaPago(FacturaPago idfacturaPagoDetalleFacturaPago) {
		this.idfacturaPagoDetalleFacturaPago = idfacturaPagoDetalleFacturaPago;
	}

	public DetalleCompra getIdDetalleCompraDetalleFacturaPago() {
		return idDetalleCompraDetalleFacturaPago;
	}

	public void setIdDetalleCompraDetalleFacturaPago(DetalleCompra idDetalleCompraDetalleFacturaPago) {
		this.idDetalleCompraDetalleFacturaPago = idDetalleCompraDetalleFacturaPago;
	}

	public int getUnidadDetalleFacturaPago() {
		return unidadDetalleFacturaPago;
	}

	public void setUnidadDetalleFacturaPago(int unidadDetalleFacturaPago) {
		this.unidadDetalleFacturaPago = unidadDetalleFacturaPago;
	}

	public float getValorPagarDetalleFacturaPago() {
		return valorPagarDetalleFacturaPago;
	}

	public void setValorPagarDetalleFacturaPago(float valorPagarDetalleFacturaPago) {
		this.valorPagarDetalleFacturaPago = valorPagarDetalleFacturaPago;
	}

	public DetalleFacturaPago(Long idDetalleFacturaPago, FacturaPago idfacturaPagoDetalleFacturaPago,
			DetalleCompra idDetalleCompraDetalleFacturaPago, int unidadDetalleFacturaPago,
			float valorPagarDetalleFacturaPago) {
		super();
		this.idDetalleFacturaPago = idDetalleFacturaPago;
		this.idfacturaPagoDetalleFacturaPago = idfacturaPagoDetalleFacturaPago;
		this.idDetalleCompraDetalleFacturaPago = idDetalleCompraDetalleFacturaPago;
		this.unidadDetalleFacturaPago = unidadDetalleFacturaPago;
		this.valorPagarDetalleFacturaPago = valorPagarDetalleFacturaPago;
	}
	

	public DetalleFacturaPago() {

	}
	
	
}
