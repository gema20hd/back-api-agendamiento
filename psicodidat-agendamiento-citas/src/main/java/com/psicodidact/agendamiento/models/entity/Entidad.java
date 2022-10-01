package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "entidad")
public class Entidad implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id_entidad")
private Long idEntidad;

@Column(name = "descripcion_entidad", nullable = false, length = 400)
private String descripcionEntidad;

@Column(name = "direccion_entidad", nullable = true, length = 500)
private String direccionEntidad;
}