package com.example.examen.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.model.Categoria;
import com.example.examen.model.Reloj;

@Service
public class CategoriaService implements IntCategoriaService{

	private List<Categoria> listaCategoria;
	
	
	public CategoriaService() {
		
		listaCategoria = new LinkedList<Categoria>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Inteligentes");
		c1.setDescripcion("Relojes Inteligentes con Sistema Operativo");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Elegantes");
		c2.setDescripcion("Relojes analogicos para vestir formal");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Casuales");
		c3.setDescripcion("Relojes analogicos para vestir casual");
		
		
		listaCategoria.add(c1);
		listaCategoria.add(c2);
		listaCategoria.add(c3);
		
	}


	@Override
	public List<Categoria> listaC() {
		// TODO Auto-generated method stub
		return listaCategoria;
	}


	@Override
	public void agregarC(Categoria categoria) {
		listaCategoria.add(categoria);
		
	}


	@Override
	public void eliminarC(int id) {
		listaCategoria.remove(buscarC(id));
	
		
	}


	@Override
	public Categoria buscarC(int id) {
		for(Categoria c : listaCategoria) {
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
}
