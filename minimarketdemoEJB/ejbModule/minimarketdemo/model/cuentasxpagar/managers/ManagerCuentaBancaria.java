package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import minimarketdemo.model.core.entities.CxpCuentaBancaria;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerCuentaBancaria
 */
@Stateless
@LocalBean
public class ManagerCuentaBancaria {

    /**
     * Default constructor. 
     */
	
	@EJB
	private ManagerDAO mDAO;
	
    public ManagerCuentaBancaria() {
        // TODO Auto-generated constructor stub
    }

    public List<CxpCuentaBancaria> findAllCuentasBancarias(){
    	return mDAO.findAll(CxpCuentaBancaria.class, "codigoCta");
    }
    
    public void insertarCuentaBancaria(CxpCuentaBancaria nuevaCuenta) throws Exception{
    	
    	mDAO.insertar(nuevaCuenta);
    }
    
    public void activarDesactivarCuenta(int id_cta) throws Exception{
    	CxpCuentaBancaria cuenta = (CxpCuentaBancaria) mDAO.findById(CxpCuentaBancaria.class, id_cta);
    	cuenta.setEstadoCta(!cuenta.getEstadoCta());
    	System.out.println("activar/desactivar"+cuenta.getEstadoCta());
    	mDAO.actualizar(cuenta);
    }
    
    public void actualizarCuenta(CxpCuentaBancaria edicionCuenta) throws Exception{
    	CxpCuentaBancaria cuenta=(CxpCuentaBancaria) mDAO.findById(CxpCuentaBancaria.class, edicionCuenta.getIdCta());
    	cuenta.setCodigoCta(edicionCuenta.getCodigoCta());
    	cuenta.setEntidadCta(edicionCuenta.getEntidadCta());
    	cuenta.setSaldoCta(edicionCuenta.getSaldoCta());
    	cuenta.setEstadoCta(edicionCuenta.getEstadoCta());
    	cuenta.setDescripcionCta(edicionCuenta.getDescripcionCta());
    	cuenta.setTipoCta(edicionCuenta.getTipoCta());
    	cuenta.setNombreCta(edicionCuenta.getNombreCta());
    	mDAO.actualizar(cuenta);
    	
    }
    
    public void eliminarCuenta(int id_cta) throws Exception{
    	CxpCuentaBancaria cuenta=(CxpCuentaBancaria) mDAO.findById(CxpCuentaBancaria.class, id_cta);
    	mDAO.eliminar(CxpCuentaBancaria.class, cuenta.getIdCta());
    }
}
