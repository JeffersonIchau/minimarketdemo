package minimarketdemo.model.core.entities;
import java.io.Serializable;
import java.util.Date;
public class FacturasaCredito implements Serializable{

	private int idfactura;
	private int idproveedor;
	private String fechafactura;
	private String fechavencimiento;
	private String tipofactura;
	private Double valorfactura;
	
	public FacturasaCredito() {
		
	}
	public int getIdfactura() {
		return idfactura;
	}
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}
	
	public int getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getFechafactura() {
		return fechafactura;
	}
	public void setFechafactura(String fechafactura) {
		this.fechafactura = fechafactura;
	}
	public String getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public String getTipofactura() {
		return tipofactura;
	}
	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}
	public Double getValorfactura() {
		return valorfactura;
	}
	public void setValorfactura(Double valorfactura) {
		this.valorfactura = valorfactura;
	}
	
	
	
	
	
}