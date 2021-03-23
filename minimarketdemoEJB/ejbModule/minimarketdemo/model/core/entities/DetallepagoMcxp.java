package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detallepago_mcxp database table.
 * 
 */
@Entity
@Table(name="detallepago_mcxp")
@NamedQuery(name="DetallepagoMcxp.findAll", query="SELECT d FROM DetallepagoMcxp d")
public class DetallepagoMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer iddetalle;

	@Column(name="id_factura", nullable=false)
	private Integer idFactura;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal valorapagar;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal valorfactura;

	//bi-directional many-to-one association to CabecerapagoMcxp
	@ManyToOne
	@JoinColumn(name="codigopago", nullable=false)
	private CabecerapagoMcxp cabecerapagoMcxp;

	public DetallepagoMcxp() {
	}

	public Integer getIddetalle() {
		return this.iddetalle;
	}

	public void setIddetalle(Integer iddetalle) {
		this.iddetalle = iddetalle;
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public BigDecimal getValorapagar() {
		return this.valorapagar;
	}

	public void setValorapagar(BigDecimal valorapagar) {
		this.valorapagar = valorapagar;
	}

	public BigDecimal getValorfactura() {
		return this.valorfactura;
	}

	public void setValorfactura(BigDecimal valorfactura) {
		this.valorfactura = valorfactura;
	}

	public CabecerapagoMcxp getCabecerapagoMcxp() {
		return this.cabecerapagoMcxp;
	}

	public void setCabecerapagoMcxp(CabecerapagoMcxp cabecerapagoMcxp) {
		this.cabecerapagoMcxp = cabecerapagoMcxp;
	}

}