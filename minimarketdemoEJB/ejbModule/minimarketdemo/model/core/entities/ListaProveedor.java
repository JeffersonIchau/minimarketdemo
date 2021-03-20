package minimarketdemo.model.core.entities;

import java.io.Serializable;

public class ListaProveedor implements Serializable{

	//Al momento de crear esta clase poner "implements Serializable"
	//luego crear los atributos, constructor vacio y los getters y setters
	private int idproveedor;
	private String cedula;
	private String email;
	private String nombre;
	private String telefono;
	
	public ListaProveedor() {
		
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
