package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
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

@Entity
@Data

@Table(name="paciente_profesional")
public class PacienteProfesional implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paciente_profesional")
	private Long idPacienteProfesional;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Paciente paciente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profesional")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Profesional profesional;

}