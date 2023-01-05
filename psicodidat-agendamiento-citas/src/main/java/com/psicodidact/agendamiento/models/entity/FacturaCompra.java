package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name ="factura_compra")
public class FacturaCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_compra")
	private Long idFacturaCompra;
	
	@Column(name="descripcion_factura_compra")
	private String descripcionFacturaCompra;
	

	@Column(name="observacion_factura_compra")
	private String observacion;
	
	@Column(name="total_factura_compra")
	private Double totalFacturaCompra;
	
	@Column(name = "fecha_compra_factura")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacionFacturacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacionFacturacion= new Date();
		this.totalFacturaCompra = getTotal();
		
	}

    @NotNull(message = "El paciente no puede ser nulo")
   	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   	@JoinColumn(name="id_paciente")
   	private Paciente paciente;
    
    @NotNull(message = "La suscursal no puede ser nulo")
 	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 	@JoinColumn(name="id_sucursal")
 	private Sucursal sucursal;
    
    @JsonIgnoreProperties(value={"factura", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL)
	private List<FacturaDetalleCompra> facturaDetalles;
	
	
 	
	public Double getTotal() {
		Double total = 0.00;
		for (FacturaDetalleCompra item :facturaDetalles) {
			total = item.getSubtotal() - item.getSubtotal()*item.getDescuentoCompra() ;
		}
		return total;
	}
	
	
	
}
