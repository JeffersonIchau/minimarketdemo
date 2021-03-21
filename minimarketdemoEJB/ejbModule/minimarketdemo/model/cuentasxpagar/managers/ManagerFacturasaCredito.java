package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import minimarketdemo.model.core.entities.FacturasaCredito;
import minimarketdemo.model.core.entities.ListaProveedor;

/**
 * Session Bean implementation class ManagerFacturasaCredito
 */
@Stateless
@LocalBean
public class ManagerFacturasaCredito {

    /**
     * Default constructor. 
     */
    public ManagerFacturasaCredito() {
        // TODO Auto-generated constructor stub
    }
    
    //Direccion url de donde vamos a consumir los datos
    //No poner la url hasta donde ya se muestran los datos, esa parte se pone 
    //en el metodo de mas adelante
    String url = "http://cuenxpag.j.layershift.co.uk/comprasWeb/apirest/compras/";
    
    public List<FacturasaCredito> findListaFacturasaCredito(){
    	System.out.println("api funcionando");
    	Client cliente = ClientBuilder.newClient().register(new FacturasaCredito());
    	List<FacturasaCredito> fact = cliente
    	.target(url + "findFactura")
    	.request(MediaType.APPLICATION_JSON).get(new GenericType<List<FacturasaCredito>>() {
    		
    	});
    	
    	for(FacturasaCredito p: fact) {
    		System.out.println(p.getIdfactura());
    		System.out.println(p.getIdproveedor());
    		System.out.println(p.getFechafactura());
    		System.out.println(p.getFechavencimiento());
    		System.out.println(p.getTipofactura());
    		System.out.println(p.getValorfactura());
    	}
    	
    	return fact;
    		
    	
    }
    
    
    
    public FacturasaCredito buscarFacturasaCreditoById(int id) {
    	String idfactura = url + "idfactura/" + id;
    	Client cliente = ClientBuilder.newClient();
    	FacturasaCredito facturaaCredito = cliente.target(idfactura)
    	.request(MediaType.APPLICATION_JSON_TYPE).get(FacturasaCredito.class);
    	return facturaaCredito;
    }

}