package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;





import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	public Usuario(String username, String password, boolean enabled,Date fechaCreacion, Profesional profesional) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.fechaCreacion= fechaCreacion;
		this.profesional=profesional;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario",unique = true)
	private Long idUsuario;

	@NotEmpty(message = "no puede estar vacio")
	@Column(name = "nombre_usuario",unique = true, length = 20,nullable = false)
	private String username;

	@NotEmpty(message = "no puede estar vacio")
	@Column(name = "clave_usuario")
	private String password;
	
	//private String password2;
	
	private boolean enabled;
	
	@Transient
	private String passwordRepeat;
	
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_rol"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"id_usuario", "id_rol"})})
	private List<Rol> roles;
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@NotEmpty(message = "no puede estar vacio")
	private Profesional profesional;



}