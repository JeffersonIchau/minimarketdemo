package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the apicuentasxpagar database table.
 * 
 */
@Entity
@Table(name="apicuentasxpagar")
@NamedQuery(name="Apicuentasxpagar.findAll", query="SELECT a FROM Apicuentasxpagar a")
public class Apicuentasxpagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_apicuentas", unique=true, nullable=false)
	private Integer idApicuentas;

	@Column(name="id_factura", nullable=false)
	private Integer idFactura;

	@Column(name="id_proveedor", nullable=false)
	private Integer idProveedor;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal total;

	public Apicuentasxpagar() {
	}

	public Integer getIdApicuentas() {
		return this.idApicuentas;
	}

	public void setIdApicuentas(Integer idApicuentas) {
		this.idApicuentas = idApicuentas;
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