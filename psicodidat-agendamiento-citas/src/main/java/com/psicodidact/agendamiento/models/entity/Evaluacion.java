package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="evaluacion")
public class Evaluacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evaluacion")
	private Long idEvaluacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cita")
	private Cita cita;
	
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


	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	
	
}
