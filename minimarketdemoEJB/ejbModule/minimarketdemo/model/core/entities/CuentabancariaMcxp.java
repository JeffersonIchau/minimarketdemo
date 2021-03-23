package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cuentabancaria_mcxp database table.
 * 
 */
@Entity
@Table(name="cuentabancaria_mcxp")
@NamedQuery(name="CuentabancariaMcxp.findAll", query="SELECT c FROM CuentabancariaMcxp c")
public class CuentabancariaMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer codigocb;

	@Column(nullable=false, length=100)
	private String descripcioncb;

	@Column(nullable=false, length=100)
	private String entidadbancariacb;

	@Column(nullable=false)
	private Boolean estadocb;

	@Column(nullable=false, length=100)
	private String propietariocb;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal saldocb;

	@Column(nullable=false, length=10)
	private String tipocb;

	//bi-directional many-to-one association to CabecerapagoMcxp
	@OneToMany(mappedBy="cuentabancariaMcxp")
	private List<CabecerapagoMcxp> cabecerapagoMcxps;

	public CuentabancariaMcxp() {
	}

	public Integer getCodigocb() {
		return this.codigocb;
	}

	public void setCodigocb(Integer codigocb) {
		this.codigocb = codigocb;
	}

	public String getDescripcioncb() {
		return this.descripcioncb;
	}

	public void setDescripcioncb(String descripcioncb) {
		this.descripcioncb = descripcioncb;
	}

	public String getEntidadbancariacb() {
		return this.entidadbancariacb;
	}

	public void setEntidadbancariacb(String entidadbancariacb) {
		this.entidadbancariacb = entidadbancariacb;
	}

	public Boolean getEstadocb() {
		return this.estadocb;
	}

	public void setEstadocb(Boolean estadocb) {
		this.estadocb = estadocb;
	}

	public String getPropietariocb() {
		return this.propietariocb;
	}

	public void setPropietariocb(String propietariocb) {
		this.propietariocb = propietariocb;
	}

	public BigDecimal getSaldocb() {
		return this.saldocb;
	}

	public void setSaldocb(BigDecimal saldocb) {
		this.saldocb = saldocb;
	}

	public String getTipocb() {
		return this.tipocb;
	}

	public void setTipocb(String tipocb) {
		this.tipocb = tipocb;
	}

	public List<CabecerapagoMcxp> getCabecerapagoMcxps() {
		return this.cabecerapagoMcxps;
	}

	public void setCabecerapagoMcxps(List<CabecerapagoMcxp> cabecerapagoMcxps) {
		this.cabecerapagoMcxps = cabecerapagoMcxps;
	}

	public CabecerapagoMcxp addCabecerapagoMcxp(CabecerapagoMcxp cabecerapagoMcxp) {
		getCabecerapagoMcxps().add(cabecerapagoMcxp);
		cabecerapagoMcxp.setCuentabancariaMcxp(this);

		return cabecerapagoMcxp;
	}

	public CabecerapagoMcxp removeCabecerapagoMcxp(CabecerapagoMcxp cabecerapagoMcxp) {
		getCabecerapagoMcxps().remove(cabecerapagoMcxp);
		cabecerapagoMcxp.setCuentabancariaMcxp(null);

		return cabecerapagoMcxp;
	}

}