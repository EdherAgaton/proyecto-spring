package com.example.examen.service;

import java.util.List;

import com.example.examen.model.Categoria;
import com.example.examen.model.Reloj;

public interface IntCategoriaService {
	
	public List<Categoria> listaC ();
	
	public void agregarC (Categoria categoria);
	
	public void eliminarC (int id);
	
	public Categoria buscarC (int id);

}
