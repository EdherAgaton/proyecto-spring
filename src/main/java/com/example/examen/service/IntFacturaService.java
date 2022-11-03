package com.example.examen.service;

import java.util.List;

import com.example.examen.model.Factura;
import com.example.examen.model.Reloj;

public interface IntFacturaService {
	
	public List<Factura> listaF ();
	
	public void agregarF (Factura factura);
	
	public void eliminarF (int id);
	
	public Factura buscarF (int id);

}
