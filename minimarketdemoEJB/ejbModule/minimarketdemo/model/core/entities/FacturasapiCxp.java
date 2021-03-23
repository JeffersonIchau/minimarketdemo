package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the facturasapi_cxp database table.
 * 
 */
@Entity
@Table(name="facturasapi_cxp")
@NamedQuery(name="FacturasapiCxp.findAll", query="SELECT f FROM FacturasapiCxp f")
public class FacturasapiCxp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id_factura", nullable=false)
	private Integer idFactura;

	@Column(name="id_proveedor", nullable=false)
	private Integer idProveedor;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal total;

	public FacturasapiCxp() {
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}