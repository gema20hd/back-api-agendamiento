package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
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

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "clave_usuario")
	private String claveUsuario;

	private Boolean estado;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="rol", joinColumns= @JoinColumn(name="id_rol"),
	inverseJoinColumns=@JoinColumn(name="id_profesional"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"id_rol", "id_profesional"})})
	private List<Rol> roles;
	
	
	

}