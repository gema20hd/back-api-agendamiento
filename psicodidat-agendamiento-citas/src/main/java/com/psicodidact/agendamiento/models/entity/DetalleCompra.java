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


@Entity
@Table(name ="detalle_compra")
public class DetalleCompra  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_compra")
	private Long idDetalleCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_compra")
	private Compra idCompraDetalleCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_servicio_compra")
	private ServicioCompra idServicioDetalleCompra;
	
	@Column(name="estado_pago_compra")
	private int estadoPagoDetalleCompra;
	
	@Column(name="periodo_compra")
	private String periodoDetalleCompra;
	
	@Column(name="descuento_compra")
	private int descuentoDetalleCompra;
	
	@Column(name="total_pagar_compra")
	private float totalPagarDetalleCompra;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idDetalleCompraCita")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cita> citaDetalleCompra;

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="idDetalleCompraDetalleFacturaPago")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleFacturaPago> detalleFacturaPagoDetalleDetalleCompra;




	public Long getIdDetalleCompra() {
		return idDetalleCompra;
	}


	public void setIdDetalleCompra(Long idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}


	public Compra getIdCompraDetalleCompra() {
		return idCompraDetalleCompra;
	}


	public void setIdCompraDetalleCompra(Compra idCompraDetalleCompra) {
		this.idCompraDetalleCompra = idCompraDetalleCompra;
	}


	public ServicioCompra getIdServicioDetalleCompra() {
		return idServicioDetalleCompra;
	}


	public void setIdServicioDetalleCompra(ServicioCompra idServicioDetalleCompra) {
		this.idServicioDetalleCompra = idServicioDetalleCompra;
	}


	public int getEstadoPagoDetalleCompra() {
		return estadoPagoDetalleCompra;
	}


	public void setEstadoPagoDetalleCompra(int estadoPagoDetalleCompra) {
		this.estadoPagoDetalleCompra = estadoPagoDetalleCompra;
	}


	public String getPeriodoDetalleCompra() {
		return periodoDetalleCompra;
	}


	public void setPeriodoDetalleCompra(String periodoDetalleCompra) {
		this.periodoDetalleCompra = periodoDetalleCompra;
	}


	public int getDescuentoDetalleCompra() {
		return descuentoDetalleCompra;
	}


	public void setDescuentoDetalleCompra(int descuentoDetalleCompra) {
		this.descuentoDetalleCompra = descuentoDetalleCompra;
	}


	public float getTotalPagarDetalleCompra() {
		return totalPagarDetalleCompra;
	}


	public void setTotalPagarDetalleCompra(float totalPagarDetalleCompra) {
		this.totalPagarDetalleCompra = totalPagarDetalleCompra;
	}


	public List<Cita> getCitaDetalleCompra() {
		return citaDetalleCompra;
	}


	public void setCitaDetalleCompra(List<Cita> citaDetalleCompra) {
		this.citaDetalleCompra = citaDetalleCompra;
	}


	public List<DetalleFacturaPago> getDetalleFacturaPagoDetalleDetalleCompra() {
		return detalleFacturaPagoDetalleDetalleCompra;
	}


	public void setDetalleFacturaPagoDetalleDetalleCompra(List<DetalleFacturaPago> detalleFacturaPagoDetalleDetalleCompra) {
		this.detalleFacturaPagoDetalleDetalleCompra = detalleFacturaPagoDetalleDetalleCompra;
	}
	
	public DetalleCompra(Long idDetalleCompra, Compra idCompraDetalleCompra, ServicioCompra idServicioDetalleCompra,
			int estadoPagoDetalleCompra, String periodoDetalleCompra, int descuentoDetalleCompra,
			float totalPagarDetalleCompra) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.idCompraDetalleCompra = idCompraDetalleCompra;
		this.idServicioDetalleCompra = idServicioDetalleCompra;
		this.estadoPagoDetalleCompra = estadoPagoDetalleCompra;
		this.periodoDetalleCompra = periodoDetalleCompra;
		this.descuentoDetalleCompra = descuentoDetalleCompra;
		this.totalPagarDetalleCompra = totalPagarDetalleCompra;

	
	}
	

	public DetalleCompra() {
		}

	
	

}
