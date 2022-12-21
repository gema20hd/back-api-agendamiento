package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "profesional")
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_profesional")
    private Long idProfesional;

	@NotEmpty(message = "no puede estar vacio")
    @Column(name = "identificacion_profesional",nullable = false, unique = true)
    private String identificacionProfesional;

    @Column(name = "nombres_profesional")
    private String nombresProfesional;

    @Column(name = "apellido_paterno_profesional")
    private String apellidoPaternoProfesional;

    @Column(name = "apellido_materno_profesional")
    private String apellidoMaternoProfesional;

    
   // @JsonFormat(pattern = "ddMMyyyy")
   // private Date fechaNacimientoProfesional;
    @Column(name = "fecha_nacimiento_profesional")
    private Date fechaNacimientoProfesional;

    @Column(name = "celular_profesional")
    private String celularProfesional;

    @Column(name = "telefono_emergencia_profesional")
    private String telefonoEmergenciaProfesional;

    
    @Column(name = "direccion_domicilio_profesional")
    private String direccionDomicilioProfesional;
	
	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de domicilio bien formada")
    @Column(name = "correo_electronico_profesional",nullable = false, unique = true)
    private String correoElectronicoProfesional;

    @Column(name = "estado_profesional")
    private String estadoProfesional;

    @Column(name = "hoja_vida")
    private String hojaVida;

    @Column(name = "nivel_educacion")
    private String nivelEducacion; //lista en el from  
   
    @Column(name = "titulo_cuarto_nivel_profesional")
    private String tituloCuartoNivelProfesional;
    
    @Transient
    private int edadProfesional;
    
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@Transient
	int edad;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
		this.edadProfesional=this.calcularFecha(this.getFechaNacimientoProfesional());
	}
    

    @NotNull(message = "El estado civil no puede ser nulo")
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado_civil")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private EstadoCivil estadoCivil;
	
    @NotNull(message = "El tipo de sangre no puede ser nulo")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_sangre")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoSangre tipoSangre;
	
	@NotNull(message = "La discapacidad no puede ser nulo")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_discapacidad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Discapacidad discapacidad;
	
	@NotNull(message = "El genero no puede ser nulo")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_genero")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Genero genero;
	
	@NotNull(message = "La profesión no puede ser nulo")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_profesion_profesional")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProfesionProfesional profesionProfesional;

	@NotNull(message = "La cuenta no puede ser nulo")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cuenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Cuenta cuenta;
	
    
	
	public int calcularFecha(Date nacimiento) {

		LocalDate nacimientoLocalDate = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate now = LocalDate.now();
		Period period = Period.between(nacimientoLocalDate, now);

		return  period.getYears();

		}
	
	
}
