package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name ="especialidad")
public class Especialidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidad")
	private Long idEspecialidad;
	
	@Column(name="descripcion_especialidad")
	private String descripcionEspecialidad;


<<<<<<< HEAD
=======
	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
>>>>>>> 0f2ed720452846ef9c0a14fdafb78e8b2473a995
	
	
}
