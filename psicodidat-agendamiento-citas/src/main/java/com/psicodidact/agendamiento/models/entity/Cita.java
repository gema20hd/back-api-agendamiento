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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	private DetalleCompra idDetalleCompraCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_oficina")
	private Oficina idOficinaCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_profesional")
	private Profesional idProfesionalCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sub_servicio")
	private SubServicio idSubServicioCita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_asistencia")
	private Asistencia idAsistenciaCita;
	
	@Column(name="fecha_cita")
	private Date fechaCita;
	
	@Column(name="hora_cita")
	private Time horaCita;
	
	@Column(name="duracion_hora_cita")
	private String duracionHoraCita;
	
	@Column(name="duracion_minutos_cita")
	private String duracionMinutosCita;
	
	@Column(name="estado_cita")
	private int estadoCita;
	
	@Column(name="numero_cita")
	private int numeroCita;
	

	@OneToMany(fetch = FetchType.LAZY,mappedBy="idCitaEvaluacion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Evaluacion> evaluacionCita;


	public Cita(Long idCita, DetalleCompra idDetalleCompraCita, Oficina idOficinaCita, Profesional idProfesionalCita,
			SubServicio idSubServicioCita, Asistencia idAsistenciaCita, Date fechaCita, Time horaCita,
			String duracionHoraCita, String duracionMinutosCita, int estadoCita, int numeroCita) {
		super();
		this.idCita = idCita;
		this.idDetalleCompraCita = idDetalleCompraCita;
		this.idOficinaCita = idOficinaCita;
		this.idProfesionalCita = idProfesionalCita;
		this.idSubServicioCita = idSubServicioCita;
		this.idAsistenciaCita = idAsistenciaCita;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.duracionHoraCita = duracionHoraCita;
		this.duracionMinutosCita = duracionMinutosCita;
		this.estadoCita = estadoCita;
		this.numeroCita = numeroCita;

	}
	
	public Cita() {

	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public DetalleCompra getIdDetalleCompraCita() {
		return idDetalleCompraCita;
	}

	public void setIdDetalleCompraCita(DetalleCompra idDetalleCompraCita) {
		this.idDetalleCompraCita = idDetalleCompraCita;
	}

	public Oficina getIdOficinaCita() {
		return idOficinaCita;
	}

	public void setIdOficinaCita(Oficina idOficinaCita) {
		this.idOficinaCita = idOficinaCita;
	}

	public Profesional getIdProfesionalCita() {
		return idProfesionalCita;
	}

	public void setIdProfesionalCita(Profesional idProfesionalCita) {
		this.idProfesionalCita = idProfesionalCita;
	}

	public SubServicio getIdSubServicioCita() {
		return idSubServicioCita;
	}

	public void setIdSubServicioCita(SubServicio idSubServicioCita) {
		this.idSubServicioCita = idSubServicioCita;
	}

	public Asistencia getIdAsistenciaCita() {
		return idAsistenciaCita;
	}

	public void setIdAsistenciaCita(Asistencia idAsistenciaCita) {
		this.idAsistenciaCita = idAsistenciaCita;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Time getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(Time horaCita) {
		this.horaCita = horaCita;
	}

	public String getDuracionHoraCita() {
		return duracionHoraCita;
	}

	public void setDuracionHoraCita(String duracionHoraCita) {
		this.duracionHoraCita = duracionHoraCita;
	}

	public String getDuracionMinutosCita() {
		return duracionMinutosCita;
	}

	public void setDuracionMinutosCita(String duracionMinutosCita) {
		this.duracionMinutosCita = duracionMinutosCita;
	}

	public int getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(int estadoCita) {
		this.estadoCita = estadoCita;
	}

	public int getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(int numeroCita) {
		this.numeroCita = numeroCita;
	}

	public List<Evaluacion> getEvaluacionCita() {
		return evaluacionCita;
	}

	public void setEvaluacionCita(List<Evaluacion> evaluacionCita) {
		this.evaluacionCita = evaluacionCita;
	}

}

