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
import javax.validation.constraints.NotNull;

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
@Table(name ="servicio_compra")
public class ServicioCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servicio_compra")
	private Long idServicioCompra;
	
	@Column(name="descripcion_servicio_compra")
	private String descripcionServicioCompra;
	
	@Column(name="costo_servicio_compra")
	private float costoServicioCompra;
	
    @NotNull(message = "La especialidad no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_especialidad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Especialidad especialidad;

	
    @NotNull(message = "El servicio no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_servicio")
	private Servicio servicio;
    
   /* @NotNull(message = "El subservicio no puede ser nulo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_sub_servicio")
	private SubServicio subServicio;
    
    
    @NotNull(message = "El paciente no puede ser nulo")
   	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   	@JoinColumn(name="id_paciente")
   	private Paciente paciente;
    
    @NotNull(message = "La suscursal no puede ser nulo")
 	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
 	@JoinColumn(name="id_sucursal")
 	private Sucursal sucursal;
 	*/
	
	
}
