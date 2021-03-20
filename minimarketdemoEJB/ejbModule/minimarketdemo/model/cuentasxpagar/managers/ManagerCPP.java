package minimarketdemo.model.cuentasxpagar.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import minimarketdemo.model.core.entities.Apicuentasxpagar;


/**
 * Session Bean implementation class ManagerCxP
 */
@Stateless
@LocalBean
public class ManagerCPP {

    @PersistenceContext
    private EntityManager em;
	/**
     * Default constructor. 
     */
	
    public ManagerCPP() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Apicuentasxpagar> findAllcuentasxpagar(){
    	return em.createNamedQuery("Apicuentasxpagar.findAll", Apicuentasxpagar.class).getResultList();
    }
    
    
    

}
