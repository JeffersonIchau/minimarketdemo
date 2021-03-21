package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.FacturasaCredito;
import minimarketdemo.model.core.entities.ListaProveedor;
import minimarketdemo.model.cuentasxpagar.managers.ManagerFacturasaCredito;
import minimarketdemo.model.cuentasxpagar.managers.ManagerListaProveedor;

@Named
@SessionScoped
public class BeanFacturasaCredito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerFacturasaCredito managerFacturasaCredito;
	private List<FacturasaCredito> listaFacturasaCredito;
	
	public BeanFacturasaCredito() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaFacturasaCredito= managerFacturasaCredito.findListaFacturasaCredito();
	}

	//Navegacion a la ventana de reporte de proveedores desde el menu
		//de reportes de administrador
	public String actionMenuReporteFacturasaCredito() {
		listaFacturasaCredito= managerFacturasaCredito.findListaFacturasaCredito();
		return "reportefacturasaCredito";
	}

	public List<FacturasaCredito> getListaFacturasaCredito() {
		return listaFacturasaCredito;
	}

	public void setListaFacturasaCredito(List<FacturasaCredito> listaFacturasaCredito) {
		this.listaFacturasaCredito = listaFacturasaCredito;
	}
	
	

}