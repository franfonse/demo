package com.example.integrador.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="repuesto")
public class Repuesto {
	
	@Id
	@GeneratedValue
	private long idrepuesto;
	
	private String descripcion;
	private float costo;
	private String url;
	
	@OneToMany(mappedBy="repuesto", cascade = CascadeType.ALL)
	List<RepDetalle> listaRepDetalles;

	
	// Constructor
	
	public Repuesto() {
		// TODO Auto-generated constructor stub
	}
	
	public Repuesto(String descripcion, float costo, String url) {
		this.descripcion = descripcion;
		this.costo = costo;
		this.url = url;
	}
	
	
	// Getters and Setters


	public long getIdrepuesto() {
		return idrepuesto;
	}


	public void setIdrepuesto(long idrepuesto) {
		this.idrepuesto = idrepuesto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getCosto() {
		return costo;
	}


	public void setCosto(float costo) {
		this.costo = costo;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<RepDetalle> getListaRepDetalles() {
		return listaRepDetalles;
	}


	public void setListaRepDetalles(List<RepDetalle> listaRepDetalles) {
		this.listaRepDetalles = listaRepDetalles;
	}
	
	

}
