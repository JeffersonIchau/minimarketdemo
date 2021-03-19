package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.CxpCuentaBancaria;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.cuentasxpagar.managers.ManagerCuentaBancaria;

@Named
@SessionScoped
public class BeanCuentaBancaria implements Serializable {
	
	@EJB
	private ManagerCuentaBancaria managerCuentaBancaria;
	
	private List<CxpCuentaBancaria> listaCuentasBancarias;
	private CxpCuentaBancaria nuevaCuentaBancaria;
	private CxpCuentaBancaria edicionCuentaBancaria;

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
		
		nuevaCuentaBancaria=new CxpCuentaBancaria();
		//nuevaCuentaBancaria.setCodigoCta("CTA-BAN-000" + nuevaCuentaBancaria.getIdCta().toString());
		nuevaCuentaBancaria.setCodigoCta("CTA-BAN-00" );
		nuevaCuentaBancaria.setEstadoCta(true);
		return "cuentas_nuevo";
	}
	
	public void actionListenerInsertarNuevaCuenta() {
		try {
			managerCuentaBancaria.insertarCuentaBancaria(nuevaCuentaBancaria);
			listaCuentasBancarias=managerCuentaBancaria.findAllCuentasBancarias();
			nuevaCuentaBancaria= new CxpCuentaBancaria();
			//nuevaCuentaBancaria.setCodigoCta("CTA-BAN-000" + nuevaCuentaBancaria.getIdCta().toString());
			nuevaCuentaBancaria.setEstadoCta(true);
			JSFUtil.crearMensajeINFO("Cuenta insertada.");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void ActionListenerActivarDesactivarCuenta(int id_cta) {
		try {
			managerCuentaBancaria.activarDesactivarCuenta(id_cta);
			listaCuentasBancarias = managerCuentaBancaria.findAllCuentasBancarias();
			JSFUtil.crearMensajeINFO("Usuarion activado/desactivado");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSelecccionarEdicionCuenta(CxpCuentaBancaria cuenta) {
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

	public List<CxpCuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}

	public void setListaCuentasBancarias(List<CxpCuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}

	public CxpCuentaBancaria getNuevaCuentaBancaria() {
		return nuevaCuentaBancaria;
	}

	public void setNuevaCuentaBancaria(CxpCuentaBancaria nuevaCuentaBancaria) {
		this.nuevaCuentaBancaria = nuevaCuentaBancaria;
	}

	public CxpCuentaBancaria getEdicionCuentaBancaria() {
		return edicionCuentaBancaria;
	}

	public void setEdicionCuentaBancaria(CxpCuentaBancaria edicionCuentaBancaria) {
		this.edicionCuentaBancaria = edicionCuentaBancaria;
	}
	
	

}
