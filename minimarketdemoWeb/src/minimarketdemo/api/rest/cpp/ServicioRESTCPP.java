package minimarketdemo.api.rest.cpp;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import minimarketdemo.model.core.entities.Apicuentasxpagar;
import minimarketdemo.model.cuentasxpagar.managers.ManagerCPP;

@RequestScoped
@Path("cuentaspp")
@Produces("application/json")
@Consumes("application/json")
public class ServicioRESTCPP {
	
	@EJB
	private ManagerCPP mCpp;
	
	@GET
	@Path(value = "findCpp")
	public List<Apicuentasxpagar> findCpp(){
		return mCpp.findAllcuentasxpagar();
	}

}
