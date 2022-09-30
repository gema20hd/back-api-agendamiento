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
@Table(name = "unidad_educativa")
@Data
public class UnidadEducativa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_unidad_educativa")
	private Long idUnidadEducativa;
	
	@Column(name = "codigo_institucion")
	private String codigoInstitucion;
	
	@Column(name = "nombre_unidad_educativa")
	private String nombreUnidadEducativa;
	
	@Column(name = "direccion_unidad_educativa")
	private String direccionUnidadEducativa;
	

    

}
