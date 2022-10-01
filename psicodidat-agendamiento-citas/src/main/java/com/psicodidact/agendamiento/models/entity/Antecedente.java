
package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name="antecedente")
public class Antecedente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_antecedente")
	private Long idAntecedente;
	
	@Column(name="sintoma_antecedente")
	private String sintomaAntecedente;
	
	@Column(name="enfermedad_antecedente")
	private String enfermedadAntecedente;
	
	@Column(name="enfermedad_paterna")
	private String enfermedadPaterna;
	
	@Column(name="enfermedad_materna")
	private String enfermedadMaterna;
	
	@Column(name="enfermedad_representante")
	private String enfermedadRepresentante;
	
	@Column(name="tratamiento_antecedente")
	private String tratamientoAntecedente;
	
	@Column(name="alergia_antecedente")
	private String alergiaAntecedente;
	
	@Column(name="medicamento_antecedente")
	private String medicamentoAntecedente;
	
	
}
