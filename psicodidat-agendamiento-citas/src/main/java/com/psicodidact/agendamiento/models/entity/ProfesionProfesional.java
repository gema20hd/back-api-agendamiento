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
//import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "profesion_profesional")
public class ProfesionProfesional implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_profesion_profesional")
	private Long idProfesionProfesional; 
	
	//@NotNull(message ="no puede estar vacio")
	@Column(name = "tercer_nivel_profesion_profesional")
	private String tercerNivelProfesionProfesional;
	
	

}
