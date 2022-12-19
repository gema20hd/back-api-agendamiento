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
@Table(name ="compra")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Long idCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente pacienteCompra;
	

	@Column(name = "fecha_emision_compra")
	@Temporal(TemporalType.DATE)
	private Date fechaEmisionCompra;
	
	@PrePersist
	public void prePersist() {
		this.fechaEmisionCompra = new Date();
	}
	
	/*
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idCompraDetalleCompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleCompra> detalleCompraCompra;
*/
	
	
	
	
	

}
