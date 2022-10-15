package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_actividad")
	 private long idActividad;
	
	@Column(name = "descripcion_actividad")
    private String descripcionActividad;


}
