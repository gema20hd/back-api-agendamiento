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

	@Column(name="direccion_trabajo")
	private String direccionTrabajo;
	
	// recion Mucho a uno 
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="id_tipo_trabajo")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private TipoTrabajo tipoTrabajo;
}