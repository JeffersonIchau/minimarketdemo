package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import minimarketdemo.model.core.entities.ListaProveedor;

/**
 * Session Bean implementation class ManagerListaProveedor
 */
@Stateless
@LocalBean
public class ManagerListaProveedor {

    /**
     * Default constructor. 
     */
    public ManagerListaProveedor() {
        // TODO Auto-generated constructor stub
    }
    
    //Direccion url de donde vamos a consumir los datos
    //No poner la url hasta donde ya se muestran los datos, esa parte se pone 
    //en el metodo de mas adelante
    String url = "http://cuenxpag.j.layershift.co.uk/comprasWeb/apirest/compras/";
    
    public List<ListaProveedor> findListaProveedor(){
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	Client cliente = ClientBuilder.newClient().register(new ListaProveedor());
    	List<ListaProveedor> pro = cliente
    	.target(url + "findProveedor")
    	.request(MediaType.APPLICATION_JSON).get(new GenericType<List<ListaProveedor>>() {
    		
    	});
    	
    	for(ListaProveedor p: pro) {
    		System.out.println(p.getIdproveedor());
    		System.out.println(p.getCedula());
    		System.out.println(p.getEmail());
    		System.out.println(p.getNombre());
    		System.out.println(p.getTelefono());
    	}
    	
    	return pro;
    		
    	
    }
    
    
    
    public ListaProveedor buscarProveedorById(int id) {
    	String idprov = url + "idproveedor/" + id;
    	Client cliente = ClientBuilder.newClient();
    	ListaProveedor proveedor = cliente.target(idprov)
    	.request(MediaType.APPLICATION_JSON_TYPE).get(ListaProveedor.class);
    	return proveedor;
    }
    
    
    

}
