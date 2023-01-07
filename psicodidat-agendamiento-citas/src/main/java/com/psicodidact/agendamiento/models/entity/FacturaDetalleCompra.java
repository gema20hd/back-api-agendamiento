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
	
	
	@Column(name="periodo_compra_factura")
	private String periodoCompraFactura;
	
	@Column(name="descuento_compra")
	private int descuentoCompra;
	
	@Column(name="cantidad_producto")
	private Integer cantidad;
	
	@Column(name = "fecha_creacion_detalle_factura")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionDetalle;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacionDetalle = new Date();
	}
	
	public Double getSubtotal() {
		return cantidad.doubleValue() * preciosProducto.getPrecio();
	}
	
	
    @NotNull(message = "El factura no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_factura_Compra")
	private FacturaCompra factura;

   
    @NotNull(message = "El precio del producto no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_precio_producto")
	private PreciosProducto preciosProducto;




	
	

}
