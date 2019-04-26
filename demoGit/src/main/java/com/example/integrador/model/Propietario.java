package com.example.integrador.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="propietario")
public class Propietario {

	@Id
	@GeneratedValue
	private long idpropietario;
	
	private String nombre;
	private String apellido;
	private String email;
	
	@OneToMany(mappedBy="propietario", cascade = CascadeType.ALL)
	List<Orden> listaOrdenes;
	
	// Contructor
	
	
	public Propietario() {
		// TODO Auto-generated constructor stub
	}
	
	public Propietario(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	
	// Getters and Setters


	public long getIdpropietario() {
		return idpropietario;
	}

	public void setIdpropietario(long idpropietario) {
		this.idpropietario = idpropietario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Orden> getListaOrdenes() {
		return listaOrdenes;
	}

	public void setListaOrdenes(List<Orden> listaOrdenes) {
		this.listaOrdenes = listaOrdenes;
	}
	
	
	
}
