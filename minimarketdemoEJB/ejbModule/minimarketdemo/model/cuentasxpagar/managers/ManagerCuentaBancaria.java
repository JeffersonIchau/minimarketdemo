package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.CuentaBancaria;
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

    public List<CuentaBancaria> findAllCuentasBancarias(){
    	return mDAO.findAll(CuentaBancaria.class, "codigoCta");
    }
    
    public void insertarCuentaBancaria(CuentaBancaria nuevaCuenta) throws Exception{
    	mDAO.insertar(nuevaCuenta);
    }
    
    public void actualizarCuenta(CuentaBancaria edicionCuenta) throws Exception{
    	CuentaBancaria cuenta=(CuentaBancaria) mDAO.findById(CuentaBancaria.class, edicionCuenta.getIdCta());
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
    	CuentaBancaria cuenta=(CuentaBancaria) mDAO.findById(CuentaBancaria.class, id_cta);
    	mDAO.eliminar(CuentaBancaria.class, cuenta.getIdCta());
    }
}
