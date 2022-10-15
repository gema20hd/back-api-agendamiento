package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="trabajo")
public class Trabajo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trabajo")
	private Long idTrabajo;
	@Column(name="descripcion_trabajo")
	private String descripcionTrabajo;
	@Column(name="tipo_trabajo")
	private String tipoTrabajo;
	@Column(name="direccion_trabajo")
	private String direccionTrabajo;
}