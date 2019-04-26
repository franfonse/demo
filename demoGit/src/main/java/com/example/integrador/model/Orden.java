package com.example.integrador.model;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="orden")
public class Orden {
	
	@Id
	@GeneratedValue
	private long idorden;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "propietarioid")
	private Propietario propietario;
	
	private Date fecha;
	private String marca;
	private String patente;
	private String detalle;
	
	@OneToMany(mappedBy="orden", cascade = CascadeType.ALL)
	List<RepDetalle> listaRepdetalles;

	
	// Contructor
	
	
	public Orden() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Orden(Propietario propietario, Date fecha, String marca, String patente, String detalle) {
		this.propietario = propietario;
		this.fecha = fecha;
		this.marca = marca;
		this.patente = patente;
		this.detalle = detalle;
		this.propietario = propietario;
	}


	// Getters and Setters
	
	
	public long getIdorden() {
		return idorden;
	}


	public void setIdorden(long idorden) {
		this.idorden = idorden;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public void setPropietario(Optional<Propietario> propietario) {
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public List<RepDetalle> getListaRepdetalles() {
		return listaRepdetalles;
	}


	public void setListaRepdetalles(List<RepDetalle> listaRepdetalles) {
		this.listaRepdetalles = listaRepdetalles;
	}


	
	
	

}
