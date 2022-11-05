package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;




@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	@Transient 
	UsuarioAux usuarioAux = new UsuarioAux();
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre_usuario",unique = true, length = 20)
	private String username;

	@Column(name = "clave_usuario")
	private String password;


	private boolean enabled = true;

	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

  
	public String getUsername() {
    	System.out.println("Hola Mundo"+username);
		return username;
	}

	//@PrePersist
	public void setUsername(String username) {
		this.username =  usuarioAux.usuarioCorreo(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = usuarioAux.passwordEncry(password);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_rol"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"id_usuario", "id_rol"})})
	private List<Rol> roles;
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Profesional profesional;






}