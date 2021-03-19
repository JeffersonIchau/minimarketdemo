package minimarketdemo.controller.cuentasxpagar;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.seguridades.BeanSegLogin;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.cuentasxpagar.managers.ManagerCxP;

@Named
@SessionScoped
public class BeanAdmin implements Serializable {
	
	@EJB
	private ManagerCxP managerCxP;
	
	private List<SegUsuario> listaUsuarios;
	private SegUsuario nuevoUsuario;
	private SegUsuario edicionUsuario;
	
	@Inject
	private BeanSegLogin beanSegLogin;

	public BeanAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaUsuarios = managerCxP.findAllUsuarios();
	}
	
	public String actionMenuUsuarios() {
		listaUsuarios = managerCxP.findAllUsuarios();
		return "usuarios";
	}
	
	public String actionMenuNuevoUsuario() {
		nuevoUsuario=new SegUsuario();
		nuevoUsuario.setActivo(true);
		return "usuarios_nuevo";
	}
	
	public void actionListenerInsertarNuevoUsuario() {
		try {
			managerCxP.insertarUsuario(beanSegLogin.getLoginDTO(), nuevoUsuario);
			listaUsuarios=managerCxP.findAllUsuarios();
			nuevoUsuario= new SegUsuario();
			nuevoUsuario.setActivo(true);
			JSFUtil.crearMensajeINFO("Usuario insertado.");
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerActivarDesactivarUsuario(int idSegUsuario) {
		try {
			managerCxP.activarDesactivarUsuario(idSegUsuario);
			listaUsuarios = managerCxP.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario activado/desactivado");
		}catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String actionSeleccionarEdicionUsuario(SegUsuario usuario) {
		edicionUsuario=usuario;
		return "usuarios_edicion";
	}
	
	public void actionListenerActualizarEdicionUsuario() {
		try {
			managerCxP.actualizarUsuario(beanSegLogin.getLoginDTO(), edicionUsuario);
			listaUsuarios=managerCxP.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario actualizado.");
		}catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void actionListenerEliminarUsuario(int idSegUsuario) {
		try {
			managerCxP.eliminarUsuario(idSegUsuario);
			listaUsuarios=managerCxP.findAllUsuarios();
			JSFUtil.crearMensajeINFO("Usuario eliminado.");
		} catch(Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<SegUsuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<SegUsuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public SegUsuario getNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(SegUsuario nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	public SegUsuario getEdicionUsuario() {
		return edicionUsuario;
	}

	public void setEdicionUsuario(SegUsuario edicionUsuario) {
		this.edicionUsuario = edicionUsuario;
	}
	
	
	
	
	

}
