package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cabecera_pago database table.
 * 
 */
@Entity
@Table(name="cabecera_pago")
@NamedQuery(name="CabeceraPago.findAll", query="SELECT c FROM CabeceraPago c")
public class CabeceraPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago", unique=true, nullable=false)
	private Integer idPago;

	@Column(name="descripcion_pago", nullable=false, length=100)
	private String descripcionPago;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pago", nullable=false)
	private Date fechaPago;

	@Column(name="nro_pago", nullable=false, length=14)
	private String nroPago;

	//bi-directional many-to-one association to CuentaBancaria
	@ManyToOne
	@JoinColumn(name="id_cta", nullable=false)
	private CuentaBancaria cuentaBancaria;

	//bi-directional many-to-one association to Proveedore
	@ManyToOne
	@JoinColumn(name="id_proveedor", nullable=false)
	private Proveedore proveedore;

	//bi-directional many-to-one association to DetallePago
	@OneToMany(mappedBy="cabeceraPago")
	private List<DetallePago> detallePagos;

	public CabeceraPago() {
	}

	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
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

	public String getNroPago() {
		return this.nroPago;
	}

	public void setNroPago(String nroPago) {
		this.nroPago = nroPago;
	}

	public CuentaBancaria getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Proveedore getProveedore() {
		return this.proveedore;
	}

	public void setProveedore(Proveedore proveedore) {
		this.proveedore = proveedore;
	}

	public List<DetallePago> getDetallePagos() {
		return this.detallePagos;
	}

	public void setDetallePagos(List<DetallePago> detallePagos) {
		this.detallePagos = detallePagos;
	}

	public DetallePago addDetallePago(DetallePago detallePago) {
		getDetallePagos().add(detallePago);
		detallePago.setCabeceraPago(this);

		return detallePago;
	}

	public DetallePago removeDetallePago(DetallePago detallePago) {
		getDetallePagos().remove(detallePago);
		detallePago.setCabeceraPago(null);

		return detallePago;
	}

}