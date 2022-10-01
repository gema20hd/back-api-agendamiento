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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Data
@Table(name = "profesional")
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_profesional")
    private Long idProfesional;


    @Column(name = "identificacion_profesional")
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

    @Column(name = "direccion_domicilio_profesional")
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
	@JoinColumn(name="id_profesion_profesional")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProfesionProfesional profesionProfesional;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cuenta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Cuenta cuenta;

}
