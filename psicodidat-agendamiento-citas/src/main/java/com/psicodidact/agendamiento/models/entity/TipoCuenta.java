package com.psicodidact.agendamiento.models.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "tipo_cuenta")
@Data
public class TipoCuenta implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tipo_cuenta")
	private Long idTipoCuenta;
	
	@Column(name = "descripcion_tipo_cuenta")
	private String descripcioTipoCuenta;

}
