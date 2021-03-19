package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Proveedor;
import minimarketdemo.model.core.entities.Proveedore;
import minimarketdemo.model.cuentasxpagar.managers.ManagerProveedor;

@Named
@SessionScoped
public class BeanCxpProveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerProveedor managerProveedor;
	private List<Proveedor> listaProveedores;
	

	public BeanCxpProveedor() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaProveedores = managerProveedor.ListaProveedor();
	}
	
	//public String actionCargarMenuModulos() {
		//listaModulos=mSeguridades.findAllModulos();
		//return "modulos?faces-redirect=true";
	//}
	
	public String actionMenuProveedores() {
		
		listaProveedores = managerProveedor.ListaProveedor();
		return "proveedores";
	}

	public List<Proveedor> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(List<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	
	
	

}
