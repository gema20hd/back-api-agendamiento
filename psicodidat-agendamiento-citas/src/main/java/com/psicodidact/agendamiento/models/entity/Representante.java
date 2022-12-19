
package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="representante")
public class Representante implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_representante")
	private Long idRepresentante;

	
	@Column(name="identificacion_representante")
	private String identificacionRepresentante;
	
	@Column(name="apellido_paterno_representante")
	private String apellidoPaternoRepresentante;
	
	@Column(name="apellido_materno_representante")
	private String apellidoMaternoRepresentante;
	
	@Column(name="nombres_representante")
	private String nombresRepresentante;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento_representante")
	private Date fechaNacimientoRepresentante;
	
	@Column(name="correo_electronico_representante")
	private String correoElectronicoRepresentante;
	
	@Column(name="celular_representante")
	private String celularRepresentante;
	
	@Column(name="telefono_emergencia_representante")
	private String telefonoEmergenciaRepresentante;
	
	@Column(name="parentesco_representante")
	private String parentescoRepresentante;
	
	@Column(name="direccion_domicilio_representan")
	private String direccionDomicilioRepresentan;
	
	@Column(name="estado_representante")
	private String estadoRepresentante;
	
    @Column(name = "edad_representante")
    private int edadRepresentante;
    
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
	}
	
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
}
