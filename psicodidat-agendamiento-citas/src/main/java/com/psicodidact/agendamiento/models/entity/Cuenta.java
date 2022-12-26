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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(name = "numero_cuenta",unique = true)
	private String numeroCuenta;
	
	// recion Mucho a uno 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_banco")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@NotEmpty(message = "no puede estar vacio")
	private Banco banco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_cuenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@NotEmpty(message = "no puede estar vacio")
	private TipoCuenta tipoCuenta;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
	}

}

	
