package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cabecerapago_mcxp database table.
 * 
 */
@Entity
@Table(name="cabecerapago_mcxp")
@NamedQuery(name="CabecerapagoMcxp.findAll", query="SELECT c FROM CabecerapagoMcxp c")
public class CabecerapagoMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer codigopago;

	@Column(nullable=false)
	private Integer codigousuario;

	@Column(name="descripcion_pago", nullable=false, length=100)
	private String descripcionPago;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago", nullable=false)
	private Date fechaPago;

	//bi-directional many-to-one association to CuentabancariaMcxp
	@ManyToOne
	@JoinColumn(name="codigocb", nullable=false)
	private CuentabancariaMcxp cuentabancariaMcxp;

	//bi-directional many-to-one association to DetallepagoMcxp
	@OneToMany(mappedBy="cabecerapagoMcxp")
	private List<DetallepagoMcxp> detallepagoMcxps;

	public CabecerapagoMcxp() {
	}

	public Integer getCodigopago() {
		return this.codigopago;
	}

	public void setCodigopago(Integer codigopago) {
		this.codigopago = codigopago;
	}

	public Integer getCodigousuario() {
		return this.codigousuario;
	}

	public void setCodigousuario(Integer codigousuario) {
		this.codigousuario = codigousuario;
	}

	public String getDescripcionPago() {
		return this.descripcionPago;
	}

	public void setDescripcionPago(String descripcionPago) {
		this.descripcionPago = descripcionPago;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public CuentabancariaMcxp getCuentabancariaMcxp() {
		return this.cuentabancariaMcxp;
	}

	public void setCuentabancariaMcxp(CuentabancariaMcxp cuentabancariaMcxp) {
		this.cuentabancariaMcxp = cuentabancariaMcxp;
	}

	public List<DetallepagoMcxp> getDetallepagoMcxps() {
		return this.detallepagoMcxps;
	}

	public void setDetallepagoMcxps(List<DetallepagoMcxp> detallepagoMcxps) {
		this.detallepagoMcxps = detallepagoMcxps;
	}

	public DetallepagoMcxp addDetallepagoMcxp(DetallepagoMcxp detallepagoMcxp) {
		getDetallepagoMcxps().add(detallepagoMcxp);
		detallepagoMcxp.setCabecerapagoMcxp(this);

		return detallepagoMcxp;
	}

	public DetallepagoMcxp removeDetallepagoMcxp(DetallepagoMcxp detallepagoMcxp) {
		getDetallepagoMcxps().remove(detallepagoMcxp);
		detallepagoMcxp.setCabecerapagoMcxp(null);

		return detallepagoMcxp;
	}

}