package com.example.examen.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.examen.model.Reloj;

public interface IntRelojService {
	
	public List<Reloj> listaR ();
	
	public void agregarR (Reloj reloj);
	
	public void eliminarR (int id);
	
	public Reloj buscarR (int id);

	Page<Reloj> listarR(Pageable page);

	Page<Reloj> buscarR(java.awt.print.Pageable page);
	

}
