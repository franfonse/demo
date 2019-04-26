package com.example.integrador.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoRepDetalle extends CrudRepository <RepDetalle, Long> {
	
	public List<RepDetalle> findByOrden(Orden orden);

}