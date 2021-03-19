package minimarketdemo.model.core.entities;

import java.io.Serializable;

public class Proveedor implements Serializable{
	
	private int codigoprov;
	private String correo;
	private String nombre;
	private String telefono;
	
	public Proveedor() {
		
	}
	public int getCodigoprov() {
		return codigoprov;
	}
	public void setCodigoprov(int codigoprov) {
		this.codigoprov = codigoprov;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
