package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedores database table.
 * 
 */
@Entity
@Table(name="proveedores")
@NamedQuery(name="Proveedore.findAll", query="SELECT p FROM Proveedore p")
public class Proveedore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proveedor", unique=true, nullable=false)
	private Integer idProveedor;

	@Column(name="correo_proveedor", nullable=false, length=100)
	private String correoProveedor;

	@Column(name="nombre_proveedor", nullable=false, length=50)
	private String nombreProveedor;

	@Column(name="telefono_proveedor", nullable=false, length=10)
	private String telefonoProveedor;

	//bi-directional many-to-one association to CabeceraPago
	@OneToMany(mappedBy="proveedore")
	private List<CabeceraPago> cabeceraPagos;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="proveedore")
	private List<Factura> facturas;

	public Proveedore() {
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCorreoProveedor() {
		return this.correoProveedor;
	}

	public void setCorreoProveedor(String correoProveedor) {
		this.correoProveedor = correoProveedor;
	}

	public String getNombreProveedor() {
		return this.nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public List<CabeceraPago> getCabeceraPagos() {
		return this.cabeceraPagos;
	}

	public void setCabeceraPagos(List<CabeceraPago> cabeceraPagos) {
		this.cabeceraPagos = cabeceraPagos;
	}

	public CabeceraPago addCabeceraPago(CabeceraPago cabeceraPago) {
		getCabeceraPagos().add(cabeceraPago);
		cabeceraPago.setProveedore(this);

		return cabeceraPago;
	}

	public CabeceraPago removeCabeceraPago(CabeceraPago cabeceraPago) {
		getCabeceraPagos().remove(cabeceraPago);
		cabeceraPago.setProveedore(null);

		return cabeceraPago;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setProveedore(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setProveedore(null);

		return factura;
	}

}