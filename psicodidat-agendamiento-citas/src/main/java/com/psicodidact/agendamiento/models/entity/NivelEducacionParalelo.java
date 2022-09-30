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
@Table(name = "nivel_educacion_paralelo")
@Data
public class NivelEducacionParalelo implements Serializable{

	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_nivel_educacion")
	private Long idNivelEducacionParalelo;
	
	@Column(name = "descripcion_nivel_educacion")
	private String descripcionNivelParalelo;
	

}
