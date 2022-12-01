package com.example.examen.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.examen.model.Tienda;
import com.example.examen.repository.TiendaRepository;
import com.example.examen.service.IntTiendaService;


@Service
@Primary
public class TiendaServiceCrud implements IntTiendaService {
	
	
	@Autowired
	TiendaRepository repoTienda;

	@Override
	public List<Tienda> listaT() {
		// TODO Auto-generated method stub
		return repoTienda.findAll();
	}

	@Override
	public void eliminarT(int id) {
		repoTienda.deleteById(id);

	}

	@Override
	public Tienda buscarT(int id) {
		Optional<Tienda> optional = repoTienda.findById(id);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		return null;
	}

	@Override
	public void agregarT(Tienda tienda) {
		repoTienda.save(tienda);

	}

}
