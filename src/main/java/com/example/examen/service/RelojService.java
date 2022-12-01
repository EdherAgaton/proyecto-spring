package com.example.examen.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.examen.model.Categoria;
import com.example.examen.model.Reloj;

@Service
public class RelojService implements IntRelojService {
	
	private List<Reloj> listaRelojes;
	
	public RelojService() {
		
		listaRelojes = new LinkedList<Reloj> ();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Reloj r1 = new Reloj();
		r1.setId(1);
		r1.setNombre("Huawei Watch");
		//r1.setMarca("Huawei");
		r1.setPrecio(1500);
		r1.setDescripcion("Reloj inteligente para ejercicio");
		r1.setFecha(LocalDate.parse("17-03-1998",formato));
		r1.setImagen("reloj4.jpg");
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		r1.setCategoria(c1);
		
		Reloj r2 = new Reloj();
		r2.setId(2);
		r2.setNombre("Victorinox 13mm");
		//r2.setMarca("Victorinox");
		r2.setPrecio(3000);
		r2.setDescripcion("Reloj de acero inoxidable");
		r2.setFecha(LocalDate.parse("20-05-2001",formato));
		r2.setImagen("reloj3.jpg");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		r2.setCategoria(c2);
		
		Reloj r3 = new Reloj();
		r3.setId(1);
		r3.setNombre("Huawei Watch");
		//r3.setMarca("Huawei");
		r3.setPrecio(1500);
		r3.setDescripcion("Reloj inteligente para ejercicio");
		r3.setFecha(LocalDate.parse("17-03-1998",formato));
		r3.setImagen("reloj6.jpg");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		r3.setCategoria(c3);
		
		
		listaRelojes.add(r1);
		listaRelojes.add(r2);
		listaRelojes.add(r3);
		
		
	}
	

	@Override
	public List<Reloj> listaR() {
		// TODO Auto-generated method stub
		return listaRelojes;
	}

	@Override
	public void agregarR(Reloj reloj) {
		listaRelojes.add(reloj);

	}

	@Override
	public void eliminarR(int id) {
		listaRelojes.remove(buscarR(id));

	}

	@Override
	public Reloj buscarR(int id) {
		for(Reloj r : listaRelojes) {
			if(r.getId() == id) {
				return r;
				
			}
		}
		return null;
	}


	@Override
	public Page<Reloj> listarR(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Reloj> buscarR(java.awt.print.Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
