package com.psicodidact.agendamiento.models.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tipo_sangre")
@Data
public class TipoSangre implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tipo_sangre")
	private Long idTipoSangre;
	
	@Column(name = "descripcion_tipo_sangre")
	private String descripcionTipoSangre;

}
