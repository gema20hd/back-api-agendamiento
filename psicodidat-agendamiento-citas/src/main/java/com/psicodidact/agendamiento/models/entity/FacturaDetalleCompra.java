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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name ="factura_detalle_compra")
public class FacturaDetalleCompra  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_detalle_compra")
	private Long idFacturaDetalleCompra;
	

	
	
	@Column(name="estado_pago_factura_compra")
	private String estadoPagoFacturaCompra;
	
	@Column(name="periodo_compra_factura")
	private String periodoCompraFactura;
	
	@Column(name="descuento_compra")
	private int descuentoCompra;
	
	@Column(name="total_factura_compra")
	private float totalPagarFacturaCompra;
	

	@Column(name = "fecha_creacion_detalle_factura")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionDetalle;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacionDetalle = new Date();
	}
	
	@Column(name="cantidad_producto")
	private Integer cantidad;
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	public Double getImporte() {
		return cantidad.doubleValue() * preciosProducto.getPrecio();
	}
	
	/*public Double getTotal() {
		Double total = 0.00;
		for ( item : items) {
			total += item.getImporte();
		}
		return total;
	}
	*/
    @NotNull(message = "El factura no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_facturaCompra")
	private FacturaCompra factura;

    @NotNull(message = "El producto no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_precio_producto")
	private PreciosProducto preciosProducto;



	
	

}
