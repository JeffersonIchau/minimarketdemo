package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.CuentaBancaria;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.cuentasxpagar.managers.ManagerCuentaBancaria;

@Named
@SessionScoped
public class BeanCuentaBancaria implements Serializable {
	
	@EJB
	private ManagerCuentaBancaria managerCuentaBancaria;
	
	private List<CuentaBancaria> listaCuentasBancarias;
	private CuentaBancaria nuevaCuentaBancaria;
	private CuentaBancaria edicionCuentaBancaria;

	public BeanCuentaBancaria() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaCuentasBancarias = managerCuentaBancaria.findAllCuentasBancarias();
	}
	
	public String actionMenuCuentaBancaria() {
		listaCuentasBancarias = managerCuentaBancaria.findAllCuentasBancarias();
		return "cuentasbancarias";
	}

	public String actionMenuNuevaCuentaBancaria() {
		nuevaCuentaBancaria=new CuentaBancaria();
		return "cuentas_nuevo";
	}
	
	public void actionListenerInsertarNuevaCuenta() {
		try {
			managerCuentaBancaria.insertarCuentaBancaria(nuevaCuentaBancaria);
			listaCuentasBancarias=managerCuentaBancaria.findAllCuentasBancarias();
			nuevaCuentaBancaria= new CuentaBancaria();
			JSFUtil.crearMensajeINFO("Cuenta insertada.");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSelecccionarEdicionCuenta(CuentaBancaria cuenta) {
		edicionCuentaBancaria=cuenta;
		return "cuentas_edicion";
	}
	
	public void actionListenerActualizarEdicionCuenta() {
		try {
			managerCuentaBancaria.actualizarCuenta(edicionCuentaBancaria);
			listaCuentasBancarias=managerCuentaBancaria.findAllCuentasBancarias();
			JSFUtil.crearMensajeINFO("Cuenta actualizada.");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarCuenta(int id_cta) {
		try {
			managerCuentaBancaria.eliminarCuenta(id_cta);
			listaCuentasBancarias=managerCuentaBancaria.findAllCuentasBancarias();
			JSFUtil.crearMensajeINFO("Cuenta eliminada.");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<CuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}

	public void setListaCuentasBancarias(List<CuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}

	public CuentaBancaria getNuevaCuentaBancaria() {
		return nuevaCuentaBancaria;
	}

	public void setNuevaCuentaBancaria(CuentaBancaria nuevaCuentaBancaria) {
		this.nuevaCuentaBancaria = nuevaCuentaBancaria;
	}

	public CuentaBancaria getEdicionCuentaBancaria() {
		return edicionCuentaBancaria;
	}

	public void setEdicionCuentaBancaria(CuentaBancaria edicionCuentaBancaria) {
		this.edicionCuentaBancaria = edicionCuentaBancaria;
	}
	
	

}
