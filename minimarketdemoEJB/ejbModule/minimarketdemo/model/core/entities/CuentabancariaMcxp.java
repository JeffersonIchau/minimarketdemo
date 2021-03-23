package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuentabancaria_mcxp database table.
 * 
 */
@Entity
@Table(name="cuentabancaria_mcxp")
@NamedQuery(name="CuentabancariaMcxp.findAll", query="SELECT c FROM CuentabancariaMcxp c")
public class CuentabancariaMcxp implements Serializable {
	private static final long serialVersionUID = 1L;

	public CuentabancariaMcxp() {
	}

}