package com.example.examen.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.examen.model.Marca;
import com.example.examen.repository.MarcaRepository;
import com.example.examen.service.IntMarcaService;

@Service
@Primary
public class MarcaServiceCrud implements IntMarcaService {
	
	@Autowired
	MarcaRepository repoMarca;
	
	

	@Override
	public List<Marca> listaM() {
		// TODO Auto-generated method stub
		return repoMarca.findAll();
	}

	@Override
	public void agregarM(Marca marca) {
		// TODO Auto-generated method stub
		repoMarca.save(marca);

	}

	@Override
	public void eliminarM(int id) {
		// TODO Auto-generated method stub
		repoMarca.deleteById(id);

	}

	@Override
	public Marca buscarM(int id) {
		Optional<Marca> optional = repoMarca.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
