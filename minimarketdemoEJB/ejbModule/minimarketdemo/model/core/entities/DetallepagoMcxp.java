package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detallepago_mcxp database table.
 * 
 */
@Entity
@Table(name="detallepago_mcxp")
@NamedQuery(name="DetallepagoMcxp.findAll", query="SELECT d FROM DetallepagoMcxp d")
public class DetallepagoMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	public DetallepagoMcxp() {
	}

}