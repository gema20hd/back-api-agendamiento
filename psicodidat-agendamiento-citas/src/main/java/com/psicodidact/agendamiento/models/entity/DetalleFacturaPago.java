package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
	private FacturaPago facturaPagoDetalleFacturaPago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_detalle_compra")
	private DetalleCompra detalleCompraDetalleFacturaPago;
	
	@Column(name="unidad_detalle_factura_pago")
	private int unidadDetalleFacturaPago;
	
	@Column(name="valor_pagar_detalle_factura_pago")
	private float valorPagarDetalleFacturaPago;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	
	
	
}
