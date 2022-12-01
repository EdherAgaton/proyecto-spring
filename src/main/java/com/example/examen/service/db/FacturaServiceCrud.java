package com.example.examen.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.examen.model.Factura;
import com.example.examen.repository.FacturaRepository;
import com.example.examen.service.IntFacturaService;

@Service
@Primary
public class FacturaServiceCrud implements IntFacturaService {
	
	@Autowired
	FacturaRepository repoFactura;

	@Override
	public List<Factura> listaF() {
		// TODO Auto-generated method stub
		return repoFactura.findAll();
	}

	@Override
	public void agregarF(Factura factura) {
		// TODO Auto-generated method stub
		repoFactura.save(factura);

	}

	@Override
	public void eliminarF(int id) {
		// TODO Auto-generated method stub
		repoFactura.deleteById(id);

	}

	@Override
	public Factura buscarF(int id) {
		// TODO Auto-generated method stub
		Optional<Factura> optional = repoFactura.findById(id);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		return null;
	}

}
