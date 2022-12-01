package com.example.examen.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.model.Factura;
import com.example.examen.model.Reloj;

@Service
public class FacturaService implements IntFacturaService {
	
	private List<Factura> listaFactura;
	
	public FacturaService() {
		
		listaFactura = new LinkedList<Factura>();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Factura f1 = new Factura();
		f1.setId(1);
		
		f1.setFecha(LocalDate.parse("02-10-2022", formato));
		
		Reloj r1 = new Reloj();
		r1.setId(1);
		f1.setReloj(r1);
		
		

		Factura f2 = new Factura();
		f2.setId(2);
	
		f2.setFecha(LocalDate.parse("19-10-2001", formato));
		
		Reloj r2 = new Reloj();
		r2.setId(2);
		f2.setReloj(r2);
		
		
		listaFactura.add(f1);
		listaFactura.add(f2);
		
		
	}

	@Override
	public List<Factura> listaF() {
		// TODO Auto-generated method stub
		return listaFactura;
	}

	@Override
	public void agregarF(Factura factura) {
		listaFactura.add(factura);

	}

	@Override
	public void eliminarF(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Factura buscarF(int id) {
		for(Factura f : listaFactura) {
			if(f.getId() == id) {
				return f;
			}
		}
		return null;
	}

}
