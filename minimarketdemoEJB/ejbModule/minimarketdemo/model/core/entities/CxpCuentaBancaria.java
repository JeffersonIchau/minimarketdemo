package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the cxp_cuenta_bancaria database table.
 * 
 */
@Entity
@Table(name="cxp_cuenta_bancaria")
@NamedQuery(name="CxpCuentaBancaria.findAll", query="SELECT c FROM CxpCuentaBancaria c")
public class CxpCuentaBancaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cta", unique=true, nullable=false)
	private Integer idCta;

	@Column(name="codigo_cta", nullable=false, length=12)
	private String codigoCta;

	@Column(name="descripcion_cta", nullable=false, length=100)
	private String descripcionCta;

	@Column(name="entidad_cta", nullable=false, length=100)
	private String entidadCta;

	@Column(name="estado_cta", nullable=false)
	private Boolean estadoCta;

	@Column(name="nombre_cta", nullable=false, length=100)
	private String nombreCta;

	@Column(name="saldo_cta", nullable=false, precision=10, scale=2)
	private BigDecimal saldoCta;

	@Column(name="tipo_cta", nullable=false, length=10)
	private String tipoCta;

	public CxpCuentaBancaria() {
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

	public Boolean getEstadoCta() {
		return this.estadoCta;
	}

	public void setEstadoCta(Boolean estadoCta) {
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

}