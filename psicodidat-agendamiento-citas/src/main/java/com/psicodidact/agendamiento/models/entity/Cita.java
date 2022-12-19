package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name ="cita")
public class Cita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cita")
	private Long idCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_detalle_compra")
	private DetalleCompra detalleCompraCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_oficina")
	private Oficina oficinaCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_profesional")
	private Profesional profesional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sub_servicio")
	private SubServicio subServicioCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_asistencia")
	private Asistencia asistenciaCita;
	
	@Column(name="fecha_cita")
	private Date fechaCita;
	
	@Column(name="hora_cita")
	private Time horaCita;
	
	@Column(name="duracion_hora_cita")
	private String duracionHoraCita;
	
	@Column(name="duracion_minutos_cita")
	private int duracionMinutosCita;
	
	@Column(name="estado_cita")
	private String estadoCita;
	
	@Column(name="numero_cita")
	private int numeroCita;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
	}
  /*
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idCitaEvaluacion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Evaluacion> evaluacionCita;
	*/


}

