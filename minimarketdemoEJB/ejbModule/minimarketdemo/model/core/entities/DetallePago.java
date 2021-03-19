package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_pago database table.
 * 
 */
@Entity
@Table(name="detalle_pago")
@NamedQuery(name="DetallePago.findAll", query="SELECT d FROM DetallePago d")
public class DetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle", unique=true, nullable=false)
	private Integer idDetalle;

	@Column(name="valor_pagado", nullable=false, precision=10, scale=2)
	private BigDecimal valorPagado;

	//bi-directional many-to-one association to CabeceraPago
	@ManyToOne
	@JoinColumn(name="id_pago", nullable=false)
	private CabeceraPago cabeceraPago;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="id_factura", nullable=false)
	private Factura factura;

	public DetallePago() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public BigDecimal getValorPagado() {
		return this.valorPagado;
	}

	public void setValorPagado(BigDecimal valorPagado) {
		this.valorPagado = valorPagado;
	}

	public CabeceraPago getCabeceraPago() {
		return this.cabeceraPago;
	}

	public void setCabeceraPago(CabeceraPago cabeceraPago) {
		this.cabeceraPago = cabeceraPago;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}