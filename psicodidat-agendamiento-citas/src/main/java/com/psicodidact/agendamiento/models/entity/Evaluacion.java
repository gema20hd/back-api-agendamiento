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



@Entity
@Table(name ="evaluacion")
public class Evaluacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evaluacion")
	private Long idEvaluacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cita")
	private Cita idCitaEvaluacion;
	
	@Column(name="actividad_evaluacion")
	private String actividadEvaluacion;
	
	@Column(name="observacion_evaluacion")
	private String observacionEvaluacion;
	
	@Column(name="test_aplicado_evaluacion")
	private String testAplicadoEvaluacion;
	
	@Column(name="adaptaciones_curriculares_evaluacion")
	private String adaptacionesCurricularesEvaluacion;
	
	@Column(name="coeficiente_intelectual_evaluacion")
	private String coeficienteIntelectualEvaluacion;
	
	@Column(name="enfermedad_trastorno_evaluacion")
	private String enfermedadTrastornoEvaluacion;
	
	@Column(name="recomendaciones_evaluacion")
	private String recomendacionesEvaluacion;
	
	@Column(name="diagnostico_evaluacion")
	private String diganosticoEvaluacion;
	
	@Column(name="nuevo_proceso_evaluacion")
	private String nuevoProcesoEvaluaciones;

	public Long getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Cita getIdCitaEvaluacion() {
		return idCitaEvaluacion;
	}

	public void setIdCitaEvaluacion(Cita idCitaEvaluacion) {
		this.idCitaEvaluacion = idCitaEvaluacion;
	}

	public String getActividadEvaluacion() {
		return actividadEvaluacion;
	}

	public void setActividadEvaluacion(String actividadEvaluacion) {
		this.actividadEvaluacion = actividadEvaluacion;
	}

	public String getObservacionEvaluacion() {
		return observacionEvaluacion;
	}

	public void setObservacionEvaluacion(String observacionEvaluacion) {
		this.observacionEvaluacion = observacionEvaluacion;
	}

	public String getTestAplicadoEvaluacion() {
		return testAplicadoEvaluacion;
	}

	public void setTestAplicadoEvaluacion(String testAplicadoEvaluacion) {
		this.testAplicadoEvaluacion = testAplicadoEvaluacion;
	}

	public String getAdaptacionesCurricularesEvaluacion() {
		return adaptacionesCurricularesEvaluacion;
	}

	public void setAdaptacionesCurricularesEvaluacion(String adaptacionesCurricularesEvaluacion) {
		this.adaptacionesCurricularesEvaluacion = adaptacionesCurricularesEvaluacion;
	}

	public String getCoeficienteIntelectualEvaluacion() {
		return coeficienteIntelectualEvaluacion;
	}

	public void setCoeficienteIntelectualEvaluacion(String coeficienteIntelectualEvaluacion) {
		this.coeficienteIntelectualEvaluacion = coeficienteIntelectualEvaluacion;
	}

	public String getEnfermedadTrastornoEvaluacion() {
		return enfermedadTrastornoEvaluacion;
	}

	public void setEnfermedadTrastornoEvaluacion(String enfermedadTrastornoEvaluacion) {
		this.enfermedadTrastornoEvaluacion = enfermedadTrastornoEvaluacion;
	}

	public String getRecomendacionesEvaluacion() {
		return recomendacionesEvaluacion;
	}

	public void setRecomendacionesEvaluacion(String recomendacionesEvaluacion) {
		this.recomendacionesEvaluacion = recomendacionesEvaluacion;
	}

	public String getDiganosticoEvaluacion() {
		return diganosticoEvaluacion;
	}

	public void setDiganosticoEvaluacion(String diganosticoEvaluacion) {
		this.diganosticoEvaluacion = diganosticoEvaluacion;
	}

	public String getNuevoProcesoEvaluaciones() {
		return nuevoProcesoEvaluaciones;
	}

	public void setNuevoProcesoEvaluaciones(String nuevoProcesoEvaluaciones) {
		this.nuevoProcesoEvaluaciones = nuevoProcesoEvaluaciones;
	}

	public Evaluacion(Long idEvaluacion, Cita idCitaEvaluacion, String actividadEvaluacion,
			String observacionEvaluacion, String testAplicadoEvaluacion, String adaptacionesCurricularesEvaluacion,
			String coeficienteIntelectualEvaluacion, String enfermedadTrastornoEvaluacion,
			String recomendacionesEvaluacion, String diganosticoEvaluacion, String nuevoProcesoEvaluaciones) {
		super();
		this.idEvaluacion = idEvaluacion;
		this.idCitaEvaluacion = idCitaEvaluacion;
		this.actividadEvaluacion = actividadEvaluacion;
		this.observacionEvaluacion = observacionEvaluacion;
		this.testAplicadoEvaluacion = testAplicadoEvaluacion;
		this.adaptacionesCurricularesEvaluacion = adaptacionesCurricularesEvaluacion;
		this.coeficienteIntelectualEvaluacion = coeficienteIntelectualEvaluacion;
		this.enfermedadTrastornoEvaluacion = enfermedadTrastornoEvaluacion;
		this.recomendacionesEvaluacion = recomendacionesEvaluacion;
		this.diganosticoEvaluacion = diganosticoEvaluacion;
		this.nuevoProcesoEvaluaciones = nuevoProcesoEvaluaciones;
	}
	
	public Evaluacion() {
		
	}
	
	
	
	
}
