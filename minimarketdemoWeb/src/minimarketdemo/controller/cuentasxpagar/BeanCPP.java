package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import minimarketdemo.model.core.entities.Apicuentasxpagar;
import minimarketdemo.model.core.entities.Proveedor;
import minimarketdemo.model.cuentasxpagar.managers.ManagerCPP;
import minimarketdemo.model.cuentasxpagar.managers.ManagerProveedor;

@Named
@SessionScoped
public class BeanCPP implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerCPP managerCPP;
	private List<Apicuentasxpagar> listaCPP;
	public BeanCPP() {
		// TODO Auto-generated constructor stub
	}
	
	
	@PostConstruct
	public void inicializar() {
		listaCPP=managerCPP.findAllcuentasxpagar();
	}


	public List<Apicuentasxpagar> getLista() {
		return listaCPP;
	}

	public void setLista(List<Apicuentasxpagar> listaCPP) {
		this.listaCPP = listaCPP;
	}
	
	
	

}
