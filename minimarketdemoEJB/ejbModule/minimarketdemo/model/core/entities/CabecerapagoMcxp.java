package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cabecerapago_mcxp database table.
 * 
 */
@Entity
@Table(name="cabecerapago_mcxp")
@NamedQuery(name="CabecerapagoMcxp.findAll", query="SELECT c FROM CabecerapagoMcxp c")
public class CabecerapagoMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	public CabecerapagoMcxp() {
	}

}