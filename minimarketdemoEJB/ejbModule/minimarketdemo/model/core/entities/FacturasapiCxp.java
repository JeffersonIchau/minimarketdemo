package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facturasapi_cxp database table.
 * 
 */
@Entity
@Table(name="facturasapi_cxp")
@NamedQuery(name="FacturasapiCxp.findAll", query="SELECT f FROM FacturasapiCxp f")
public class FacturasapiCxp implements Serializable {
	private static final long serialVersionUID = 1L;

	public FacturasapiCxp() {
	}

}