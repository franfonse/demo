package com.example.integrador.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Repdetalle")
public class RepDetalle {
	
	@Id
	@GeneratedValue
	private long idrepdetalle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordenid")
	private Orden orden;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="repuestoid")
	private Repuesto repuesto;
	
	private int qty;
	private int horas;
	
	
	// Constructor
	
	public RepDetalle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RepDetalle(Orden orden, Repuesto repuesto, int qty, int horas) {
		this.orden = orden;
		this.repuesto = repuesto;
		this.qty = qty;
		this.horas = horas;
	}
	
	
	// Getters and Setters


	public long getIdrepdetalle() {
		return idrepdetalle;
	}


	public void setIdrepdetalle(long idrepdetalle) {
		this.idrepdetalle = idrepdetalle;
	}


	public Orden getOrden() {
		return orden;
	}


	public void setOrden(Orden orden) {
		this.orden = orden;
	}


	public Repuesto getRepuesto() {
		return repuesto;
	}


	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
		this.horas = horas;
	}
	

}
