package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cxp_cabecera_pago database table.
 * 
 */
@Entity
@Table(name="cxp_cabecera_pago")
@NamedQuery(name="CxpCabeceraPago.findAll", query="SELECT c FROM CxpCabeceraPago c")
public class CxpCabeceraPago implements Serializable {
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

	@Column(name="id_cta", nullable=false)
	private Integer idCta;

	@Column(name="id_usuario", nullable=false)
	private Integer idUsuario;

	//bi-directional many-to-one association to CxpDetallePago
	@OneToMany(mappedBy="cxpCabeceraPago")
	private List<CxpDetallePago> cxpDetallePagos;

	public CxpCabeceraPago() {
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

	public Integer getIdCta() {
		return this.idCta;
	}

	public void setIdCta(Integer idCta) {
		this.idCta = idCta;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<CxpDetallePago> getCxpDetallePagos() {
		return this.cxpDetallePagos;
	}

	public void setCxpDetallePagos(List<CxpDetallePago> cxpDetallePagos) {
		this.cxpDetallePagos = cxpDetallePagos;
	}

	public CxpDetallePago addCxpDetallePago(CxpDetallePago cxpDetallePago) {
		getCxpDetallePagos().add(cxpDetallePago);
		cxpDetallePago.setCxpCabeceraPago(this);

		return cxpDetallePago;
	}

	public CxpDetallePago removeCxpDetallePago(CxpDetallePago cxpDetallePago) {
		getCxpDetallePagos().remove(cxpDetallePago);
		cxpDetallePago.setCxpCabeceraPago(null);

		return cxpDetallePago;
	}

}