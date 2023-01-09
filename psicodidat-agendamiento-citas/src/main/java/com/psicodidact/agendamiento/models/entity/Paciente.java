package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="paciente")
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paciente")
	private Long idPaciente;
	
	@Column(name="identificacion_paciente")
	private String identificacionPaciente;
	
	@Column(name="nombres_paciente")
	private String nombresPaciente;
	
	@Column(name="apellido_paterno_paciente")
	private String apellidoPaternoPaciente;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento_paciente")
	private Date fechaNacimientoPaciente;
	
	@Column(name="celular_paciente")
	private String celularPaciente;
	
	@Column(name="direccion_domicilio")
	private String direccionDomicilio;
	
	@Column(name="telefono_paciente")
	private String telefonoPaciente;
	
	@Column(name="correo_electronico_paciente")
	private String correoElectronicoPaciente;
	
	@Column(name="apellido_materno_paciente")
	private String apellidoMaternoPaciente;
	
	@Column(name="estado_paciente")
	private String estadoPaciente;
	
    @Column(name = "edad_paciente")
    private String edadPaciente;
	
    
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_representante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Representante representante;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado_civil")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private EstadoCivil estadoCivil;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_sangre")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoSangre tipoSangre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_discapacidad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Discapacidad discapacidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_genero")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Genero genero;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_trabajo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Trabajo trabajo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profesion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Profesion profesion;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidad_educativa")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UnidadEducativa unidadEducativa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_nivel_educacion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private NivelEducacionParalelo nivelEducacionParalelo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_antecedente")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Antecedente antecedente;
	
/*	
	@JsonIgnoreProperties(value={"paciente", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<FacturaCompra> facturas;

*/

	
	
}