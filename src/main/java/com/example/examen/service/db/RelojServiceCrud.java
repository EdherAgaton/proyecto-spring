package com.example.examen.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.examen.model.Reloj;
import com.example.examen.repository.RelojRepository;
import com.example.examen.service.IntRelojService;

@Service
@Primary
public class RelojServiceCrud implements IntRelojService {
	
	@Autowired
	RelojRepository repoReloj; 
	
	

	@Override
	public List<Reloj> listaR() {
		// TODO Auto-generated method stub
		return repoReloj.findAll();
	}

	@Override
	public void agregarR(Reloj reloj) {
		// TODO Auto-generated method stub
		repoReloj.save(reloj);

	}

	@Override
	public void eliminarR(int id) {
		// TODO Auto-generated method stub
		repoReloj.deleteById(id);

	}

	@Override
	public Reloj buscarR(int id) {
		// TODO Auto-generated method stub
		Optional<Reloj> optional = repoReloj.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}
	
	@Override
	public Page<Reloj>listarR(Pageable page) {
	return repoReloj.findAll(page);
	}

	@Override
	public Page<Reloj> buscarR(java.awt.print.Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


}
