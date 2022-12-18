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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name ="factura_pago")
public class FacturaPago implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_pago")
	private Long idFacturaPago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pago")
	private Pago pago;
	
	
	
	@Column(name = "fecha_emision_pago")
	@Temporal(TemporalType.DATE)
	private Date fecha_emision_pago;
	
	@PrePersist
	public void prePersist() {
		this.fecha_emision_pago= new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paciente")
	private Paciente paciente;




	
	
	
}
