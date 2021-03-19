package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

/**
 * Session Bean implementation class ManagerCxP
 */
@Stateless
@LocalBean
public class ManagerCxP {

    @EJB
    private ManagerDAO mDAO;
    @EJB
    private ManagerAuditoria mAuditoria;
    
	
    public ManagerCxP() {
        // TODO Auto-generated constructor stub
    }
    
    public List<SegUsuario> findAllUsuarios(){
    	return mDAO.findAll(SegUsuario.class, "apellidos");
    }
    
    public void insertarUsuario(LoginDTO loginDTO, SegUsuario nuevoUsuario) throws Exception{
    	nuevoUsuario.setCodigo("n/a");
    	mDAO.insertar(nuevoUsuario);
    	mAuditoria.mostrarLog(loginDTO, getClass(), "insertarUsuario",
    			"Usuario ("+nuevoUsuario.getIdSegUsuario()+") " +nuevoUsuario.getApellidos()+" "+nuevoUsuario.getNombres()+" creado.");
    }
    
    public void activarDesactivarUsuario(int idSegUsuario) throws Exception{
    	SegUsuario usuario= (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
    	if(idSegUsuario==1)
    		throw new Exception("No se puede desactivar al usuario administrador.");
    	usuario.setActivo(!usuario.getActivo());
    	System.out.println("activar/desactivar "+usuario.getActivo());
    	mDAO.actualizar(usuario);
    }
    
    public void actualizarUsuario(LoginDTO loginDTO,SegUsuario edicionUsuario) throws Exception{
    	SegUsuario usuario=(SegUsuario) mDAO.findById(SegUsuario.class, edicionUsuario.getIdSegUsuario());
    	usuario.setApellidos(edicionUsuario.getApellidos());
    	usuario.setClave(edicionUsuario.getClave());
    	usuario.setCorreo(edicionUsuario.getCorreo());
    	usuario.setCodigo(edicionUsuario.getCodigo());
    	usuario.setNombres(edicionUsuario.getNombres());
    	mDAO.actualizar(usuario);
    	mAuditoria.mostrarLog(loginDTO, getClass(), "actualizarUsuario", "Usuario ("+usuario.getIdSegUsuario()+") actualizado." );
    		
    }
    
    public void eliminarUsuario(int idSegUsuario) throws Exception{
    	SegUsuario usuario = (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
    	if(usuario.getIdSegUsuario()==1)
    		throw new Exception("No se puede eliminar el usuario administrador");
    	if(usuario.getSegAsignacions().size()>0)
    		throw new Exception("No se puede eliminar el usuario porque tiene asignaciones de modulos");
    	mDAO.eliminar(SegUsuario.class, usuario.getIdSegUsuario());
    }
    
    
    
    

}
