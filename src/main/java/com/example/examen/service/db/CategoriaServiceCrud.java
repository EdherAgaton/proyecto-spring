package com.example.examen.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.examen.model.Categoria;
import com.example.examen.repository.CategoriaRepository;
import com.example.examen.service.IntCategoriaService;

@Service
@Primary
public class CategoriaServiceCrud implements IntCategoriaService {
	
	
	@Autowired
	CategoriaRepository repoCategoria;

	@Override
	public List<Categoria> listaC() {
		// TODO Auto-generated method stub
		return repoCategoria.findAll();
	}

	@Override
	public void agregarC(Categoria categoria) {
		repoCategoria.save(categoria);

	}

	@Override
	public void eliminarC(int id) {
		repoCategoria.deleteById(id);

	}

	@Override
	public Categoria buscarC(int id) {
		Optional<Categoria> optional = repoCategoria.findById(id);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		return null;
	}

}
