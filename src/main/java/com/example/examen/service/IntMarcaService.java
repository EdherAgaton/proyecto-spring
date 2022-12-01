package com.example.examen.service;

import java.util.List;


import com.example.examen.model.Marca;

public interface IntMarcaService {
	
	public List<Marca> listaM ();
	
	
	public void eliminarM (int id);
	
	public Marca buscarM (int id);

	void agregarM(Marca marca);
	

}
