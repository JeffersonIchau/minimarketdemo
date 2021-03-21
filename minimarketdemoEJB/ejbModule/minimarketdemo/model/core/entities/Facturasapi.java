package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the facturasapi database table.
 * 
 */
@Entity
@Table(name="facturasapi")
@NamedQuery(name="Facturasapi.findAll", query="SELECT f FROM Facturasapi f")
public class Facturasapi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura", unique=true, nullable=false)
	private Integer idFactura;

	@Column(name="id_proveedor", nullable=false)
	private Integer idProveedor;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal saldo;

	public Facturasapi() {
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

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}