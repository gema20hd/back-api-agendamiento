package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.*;

	@Data
	@Entity
	@Table(name = "horario_actividad")
	public class HorarioActividad implements Serializable{

	    @Id
	    @Column(name = "id_horario_actividad")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	    @SequenceGenerator(name = "sequence", sequenceName = "horario_actividad_seq", allocationSize = 1)
	    private int idHorarioActividad;
	    
	    @Column(name = "fecha_horario")
	    private Date fechaHorario;
	    
	    @Column(name = "hora_horario")
	    private Date horaHorario;
	    
	    @Column(name = "duracion_hora_horario")
	    private String duracionHoraHorario;
	    
	    @Column(name = "duracion_minutos_horario")
	    private String duracionMinutosHorario;
	    
	    @Column(name = "estado_horario")
	    private boolean estadoHorario;
	    
	    @Column(name = "numero_horario")
	    private int numeroHorario;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional")
	    private Profesional profesional;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_entidad", referencedColumnName = "id_entidad")
	    private Entidad entidad;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
	    private Actividad actividad;
	

}
