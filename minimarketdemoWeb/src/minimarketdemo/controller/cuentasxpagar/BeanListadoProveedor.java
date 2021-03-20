package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.ListaProveedor;
import minimarketdemo.model.cuentasxpagar.managers.ManagerListaProveedor;

@Named
@SessionScoped
public class BeanListadoProveedor implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagerListaProveedor managerListaProveedor;
	private List<ListaProveedor> listaProveedor;

	public BeanListadoProveedor() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaProveedor= managerListaProveedor.findListaProveedor();
	}

	//Navegacion a la ventana de reporte de proveedores desde el menu
		//de reportes de administrador
	public String actionMenuReporteProveedores() {
		listaProveedor= managerListaProveedor.findListaProveedor();
		return "reporteproveedores";
	}
	
	
	public List<ListaProveedor> getListaProveedor() {
		return listaProveedor;
	}

	public void setListaProveedor(List<ListaProveedor> listaProveedor) {
		this.listaProveedor = listaProveedor;
	}
	
	

}
