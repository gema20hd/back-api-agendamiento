package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name ="oficina")
public class Oficina implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oficina")
	private Long idOficina;
	
	@Column(name="descripcion_oficina")
	private String descripcionOficina;
	
	@Column(name="color_oficina")
	private String colorOficina;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursalOficina;
	
	



	
}
