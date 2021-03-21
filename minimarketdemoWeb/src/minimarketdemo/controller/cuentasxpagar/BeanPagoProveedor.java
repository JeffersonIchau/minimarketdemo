package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.FacturasaCredito;
import minimarketdemo.model.core.entities.ListaProveedor;
import minimarketdemo.model.core.entities.Proveedor;
import minimarketdemo.model.cuentasxpagar.managers.ManagerFacturasaCredito;
import minimarketdemo.model.cuentasxpagar.managers.ManagerListaProveedor;
import minimarketdemo.model.cuentasxpagar.managers.ManagerProveedor;

@Named
@SessionScoped
public class BeanPagoProveedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerFacturasaCredito managerFacturasaCredito;
	private ManagerProveedor managerProveedor;
	private List<FacturasaCredito> listaFacturasaCredito;
	private List<Proveedor> listaProvedor;
	
	public BeanPagoProveedor() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaFacturasaCredito= managerFacturasaCredito.findListaFacturasaCredito();
		listaProvedor= managerProveedor.ListaProveedor();
	}

	//Navegacion a la ventana de reporte de proveedores desde el menu
		//de reportes de administrador
	public String actionMenupago_proveedores() {
		listaFacturasaCredito= managerFacturasaCredito.findListaFacturasaCredito();
		listaProvedor=managerProveedor.ListaProveedor();
		return "pago_proveedores";
	}

	public List<FacturasaCredito> getListaFacturasaCredito() {
		return listaFacturasaCredito;
	}

	public void setListaFacturasaCredito(List<FacturasaCredito> listaFacturasaCredito) {
		this.listaFacturasaCredito = listaFacturasaCredito;
	}
	
	

}