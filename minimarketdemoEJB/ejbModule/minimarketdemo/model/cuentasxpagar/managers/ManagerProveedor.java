package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import minimarketdemo.model.core.entities.Proveedor;
import minimarketdemo.model.core.entities.Proveedore;

/**
 * Session Bean implementation class ManagerProveedor
 */
@Stateless
@LocalBean
public class ManagerProveedor {

    /**
     * Default constructor. 
     */
    public ManagerProveedor() {
        // TODO Auto-generated constructor stub
    }
    
    String url ="http://modulocxp.phx.enscaled.us/modComprasWeb/apirest/proveedores/";
    
    public List<Proveedor> ListaProveedor(){
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	Client cliente = ClientBuilder.newClient().register(new Proveedore());
    	List<Proveedor> proveedo = cliente
    	.target(url+"listado")
    	.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Proveedor>>(){	
    	});
    	
    	for(Proveedor p: proveedo) {
    		
    		System.out.println(p.getCodigoprov());
    		System.out.println(p.getCorreo());
    		System.out.println(p.getNombre());
    		System.out.println(p.getTelefono());
    	}
    	
    	return proveedo;
    }
    
    public Proveedor buscarproveedorById(int id) {
    	String idprov = url + "proveedorid/" + id;
    	Client cliente = ClientBuilder.newClient();
    	Proveedor proveedor = cliente.target(idprov)
    	.request(MediaType.APPLICATION_JSON_TYPE).get(Proveedor.class);
    	
    	return proveedor;
    }

}
