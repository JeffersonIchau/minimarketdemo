package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cuenta_bancaria database table.
 * 
 */
@Entity
@Table(name="cuenta_bancaria")
@NamedQuery(name="CuentaBancaria.findAll", query="SELECT c FROM CuentaBancaria c")
public class CuentaBancaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cta", unique=true, nullable=false)
	private Integer idCta;

	@Column(name="codigo_cta", nullable=false, length=12)
	private String codigoCta;

	@Column(name="descripcion_cta", nullable=false, length=100)
	private String descripcionCta;

	@Column(name="entidad_cta", nullable=false, length=50)
	private String entidadCta;

	@Column(name="estado_cta", nullable=false, length=50)
	private String estadoCta;

	@Column(name="nombre_cta", nullable=false, length=50)
	private String nombreCta;

	@Column(name="saldo_cta", nullable=false, precision=10, scale=2)
	private BigDecimal saldoCta;

	@Column(name="tipo_cta", nullable=false, length=50)
	private String tipoCta;

	//bi-directional many-to-one association to CabeceraPago
	@OneToMany(mappedBy="cuentaBancaria")
	private List<CabeceraPago> cabeceraPagos;

	public CuentaBancaria() {
	}

	public Integer getIdCta() {
		return this.idCta;
	}

	public void setIdCta(Integer idCta) {
		this.idCta = idCta;
	}

	public String getCodigoCta() {
		return this.codigoCta;
	}

	public void setCodigoCta(String codigoCta) {
		this.codigoCta = codigoCta;
	}

	public String getDescripcionCta() {
		return this.descripcionCta;
	}

	public void setDescripcionCta(String descripcionCta) {
		this.descripcionCta = descripcionCta;
	}

	public String getEntidadCta() {
		return this.entidadCta;
	}

	public void setEntidadCta(String entidadCta) {
		this.entidadCta = entidadCta;
	}

	public String getEstadoCta() {
		return this.estadoCta;
	}

	public void setEstadoCta(String estadoCta) {
		this.estadoCta = estadoCta;
	}

	public String getNombreCta() {
		return this.nombreCta;
	}

	public void setNombreCta(String nombreCta) {
		this.nombreCta = nombreCta;
	}

	public BigDecimal getSaldoCta() {
		return this.saldoCta;
	}

	public void setSaldoCta(BigDecimal saldoCta) {
		this.saldoCta = saldoCta;
	}

	public String getTipoCta() {
		return this.tipoCta;
	}

	public void setTipoCta(String tipoCta) {
		this.tipoCta = tipoCta;
	}

	public List<CabeceraPago> getCabeceraPagos() {
		return this.cabeceraPagos;
	}

	public void setCabeceraPagos(List<CabeceraPago> cabeceraPagos) {
		this.cabeceraPagos = cabeceraPagos;
	}

	public CabeceraPago addCabeceraPago(CabeceraPago cabeceraPago) {
		getCabeceraPagos().add(cabeceraPago);
		cabeceraPago.setCuentaBancaria(this);

		return cabeceraPago;
	}

	public CabeceraPago removeCabeceraPago(CabeceraPago cabeceraPago) {
		getCabeceraPagos().remove(cabeceraPago);
		cabeceraPago.setCuentaBancaria(null);

		return cabeceraPago;
	}

}