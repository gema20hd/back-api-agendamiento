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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Table(name = "cuenta")
@Data
public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	
	// recion Mucho a uno 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_banco")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Banco banco;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_cuenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoCuenta tipoCuenta;


}
