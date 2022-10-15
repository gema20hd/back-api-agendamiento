
package com.psicodidact.agendamiento.models.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long idRol;
	@Column(name="descripcion_rol")
	private String descripcionRol;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idUsuario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Usuario> usuarios;

	
	


}