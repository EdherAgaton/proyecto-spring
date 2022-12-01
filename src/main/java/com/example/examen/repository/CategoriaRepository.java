package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
