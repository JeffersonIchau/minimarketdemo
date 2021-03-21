package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cxp_detalle_pago database table.
 * 
 */
@Entity
@Table(name="cxp_detalle_pago")
@NamedQuery(name="CxpDetallePago.findAll", query="SELECT c FROM CxpDetallePago c")
public class CxpDetallePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle", unique=true, nullable=false)
	private Integer idDetalle;

	@Column(name="id_factura", nullable=false)
	private Integer idFactura;

	@Column(name="tipo_pago", nullable=false, length=100)
	private String tipoPago;

	@Column(name="valor_factura", nullable=false, precision=10, scale=2)
	private BigDecimal valorFactura;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal valorpagar;

	//bi-directional many-to-one association to CxpCabeceraPago
	@ManyToOne
	@JoinColumn(name="id_pago", nullable=false)
	private CxpCabeceraPago cxpCabeceraPago;

	public CxpDetallePago() {
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public BigDecimal getValorFactura() {
		return this.valorFactura;
	}

	public void setValorFactura(BigDecimal valorFactura) {
		this.valorFactura = valorFactura;
	}

	public BigDecimal getValorpagar() {
		return this.valorpagar;
	}

	public void setValorpagar(BigDecimal valorpagar) {
		this.valorpagar = valorpagar;
	}

	public CxpCabeceraPago getCxpCabeceraPago() {
		return this.cxpCabeceraPago;
	}

	public void setCxpCabeceraPago(CxpCabeceraPago cxpCabeceraPago) {
		this.cxpCabeceraPago = cxpCabeceraPago;
	}

}