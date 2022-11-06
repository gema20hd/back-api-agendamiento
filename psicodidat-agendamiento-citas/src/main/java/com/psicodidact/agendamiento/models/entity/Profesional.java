package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Column(name = "fecha_nacimiento_profesional")
    private String fechaNacimientoProfesional;

    @Column(name = "celular_profesional")
    private String celularProfesional;

    @Column(name = "telefono_emergencia_profesional")
    private String telefonoEmergenciaProfesional;

    
	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
    @Column(name = "direccion_domicilio_profesional",nullable = false, unique = true)
    private String direccionDomicilioProfesional;

    @Column(name = "correo_electronico_profesional")
    private String correoElectronicoProfesional;

    @Column(name = "estado_profesional")
    private Boolean estadoProfesional;

    @Column(name = "hoja_vida")
    private String hojaVida;

    @Column(name = "nivel_educacion")
    private String nivelEducacion;

    @Column(name = "titulo_cuarto_nivel_profesional")
    private String tituloCuartoNivelProfesional;
    

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

}
