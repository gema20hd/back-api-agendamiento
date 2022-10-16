package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

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


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "discapacidad")
public class Discapacidad implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_discapacidad")
	private Long idDiscapacidad;
	
	@Column(name = "porcentaje_discapacidad")
	private String porcetajeDiscapacidad;
	
	@Column(name = "descripcion_discapacidad")
	private String descripcionDiscapacidad;
	
	// recion Mucho a uno 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_discapacidad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoDiscapacidad tipoDiscapacidad;

}