package com.example.examen.service;

import java.util.List;

import com.example.examen.model.Reloj;

public interface IntRelojService {
	
	public List<Reloj> listaR ();
	
	public void agregarR (Reloj reloj);
	
	public void eliminarR (int id);
	
	public Reloj buscarR (int id);
	

}
