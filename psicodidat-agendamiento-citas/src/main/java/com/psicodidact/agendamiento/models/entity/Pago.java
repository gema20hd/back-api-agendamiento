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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name ="pago")
public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago")
	private Long idPago;
	
	@Column(name="tipo_pago")
	private String tipoPago;
	
	@Column(name="numero_transferencia_pago")
	private String numeroTransferenciaPago;
	
	@Column(name="numero_transaccion_pago")
	private String numeroTransaccionPago;
	
	@Column(name="tipo_tarjeta_pago")
	private String tipoTarjetaPago;
	
	@Column(name="numero_cheque_pago")
	private String numeroChequePago;
	
	@Column(name="numero_recibo_pago")
	private String numeroReciboPago;
	
	@Column(name="numero_factura_pago")
	private String numeroFacturaPago;
	
	@Column(name="nombre_banco_pago")
	private String nombreBancoPago;


	



	
	
	
	
}
