package com.example.examen.service;

import java.util.List;

import com.example.examen.model.Tienda;

public interface IntTiendaService {

	public List<Tienda> listaT();

	public void eliminarT(int id);

	public Tienda buscarT(int id);

	void agregarT(Tienda tienda);

}
