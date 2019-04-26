package com.example.integrador.controller;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.integrador.model.DaoOrden;
import com.example.integrador.model.DaoPropietario;
import com.example.integrador.model.DaoRepDetalle;
import com.example.integrador.model.DaoRepuesto;
import com.example.integrador.model.Orden;
import com.example.integrador.model.Propietario;
import com.example.integrador.model.RepDetalle;

@Controller
public class MainController {
	
	
	// DAOS
	
	
	@Autowired
	DaoPropietario daoPropietario;
	
	@Autowired
	DaoOrden daoOrden;
	
	@Autowired
	DaoRepuesto daoRepuesto;
	
	@Autowired
	DaoRepDetalle daoRepDetalle;
	
	
	// ACTIONS
	
	
	@RequestMapping (value="/",method = RequestMethod.GET)
	public String home() {
		
		return "homepage";
		
	}
	
	
	@RequestMapping (value="/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam long idpropietario) {
		
		
		if (daoPropietario.existsById(idpropietario) == true) {
			
			Propietario prop = daoPropietario.findById(idpropietario).get();
			
			model.addAttribute("prop", prop);
			model.addAttribute("listaOrdenes", prop.getListaOrdenes());
			
			prop.getIdpropietario();
			
			return "listaordenes";
			
		}
		
		else {
			
			return "nuevopropietario";
			 
		}
		
	}
	
	@RequestMapping (value="/irACrearOrden",method = RequestMethod.GET)
	public String goNewOrder(Model model, @ModelAttribute Propietario propietario) {
		
		daoPropietario.findById(propietario.getIdpropietario());
		
		return "creaorden";
		
	}
	
	
	@RequestMapping (value="/crearOrden", method = RequestMethod.POST)
	public String addOrden(Model model, @RequestParam long idpropietario, 
			@RequestParam String marca, @RequestParam String patente, @RequestParam String detalle) {
		
		Propietario prop = daoPropietario.findById(idpropietario).get();
		
		Orden orden = new Orden();
		
		model.addAttribute("orden", orden);
		
		orden.setPropietario(prop);
		orden.setFecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		orden.setMarca(marca);
		orden.setPatente(patente);
		orden.setDetalle(detalle);
		
		daoOrden.save(orden);
		
		model.addAttribute("listaOrdenes", prop.getListaOrdenes());
		
		
		return "listaordenes";
			
		}
	
	
	
	
	@RequestMapping (value="/nuevoPropietario", method = RequestMethod.POST)
	public String createProp(Model model, @RequestParam String nombre, 
			@RequestParam String apellido, @RequestParam String email) {
		
		Propietario nueProp = new Propietario();
		
		model.addAttribute("nueProp", nueProp);
		
		nueProp.setNombre(nombre);
		nueProp.setApellido(apellido);
		nueProp.setEmail(email);
		
		daoPropietario.save(nueProp);
		
		
		return "homepage";
		
	}
	
	@RequestMapping (value="/agregarRepOrden", method = RequestMethod.GET)
	public String addRepOrden(Model model, @RequestParam long idorden) {
		
		Orden orden = daoOrden.findById(idorden).get();
		
		model.addAttribute("orden", orden);
		model.addAttribute("listaRepDetalles", daoRepDetalle.findByOrden(orden));
		model.addAttribute("listaRepuestos", daoRepuesto.findAll());
		
		return "agregarepuestos";
		
	}
	
	@RequestMapping (value="/agregarRepuestos", method = RequestMethod.POST)
	public String addRep(Model model, @RequestParam long idorden, 
			@RequestParam int horas, @RequestParam int qty, @RequestParam long idrepuesto) {
		
		Orden orden = daoOrden.findById(idorden).get();
		
		RepDetalle rde = new RepDetalle(orden, daoRepuesto.findById(idrepuesto).get(), qty, horas);
		
		
		daoRepDetalle.save(rde);
		daoOrden.save(orden);
		
		model.addAttribute("idorden", orden.getIdorden());
		model.addAttribute("orden", orden);
		model.addAttribute("listaRepDetalles", daoRepDetalle.findByOrden(orden));
		model.addAttribute("listaRepuestos", daoRepuesto.findAll());
		
		return "agregarepuestos";
		
	}
	
	@RequestMapping (value="/imprimirOrden", method = RequestMethod.GET)
	public String imprime(Model model, @RequestParam long idorden) {
		
		
		Orden orden = daoOrden.findById(idorden).get();
		
		model.addAttribute("orden", orden);
		model.addAttribute("listaRepDetalles", daoRepDetalle.findByOrden(orden));
		
		float total = 0;
		
		for(RepDetalle rde: daoRepDetalle.findByOrden(orden)) {
			
			total = total + (rde.getQty() * rde.getRepuesto().getCosto()) + (rde.getHoras()*50);
			
		}
		
		
		model.addAttribute("total", total);
		
		return "ordenimpresa";
		
	}
	
}
