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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="detalle_compra")
public class DetalleCompra  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_compra")
	private Long idDetalleCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_compra")
	private Compra compra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_servicio_compra")
	private ServicioCompra servicioDetalleCompra;
	
	@Column(name="estado_pago_compra")
	private String estadoPagoDetalleCompra;
	
	@Column(name="periodo_compra")
	private String periodoDetalleCompra;
	
	@Column(name="descuento_compra")
	private int descuentoDetalleCompra;
	
	@Column(name="total_pagar_compra")
	private float totalPagarDetalleCompra;
	

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}





	
	

}
