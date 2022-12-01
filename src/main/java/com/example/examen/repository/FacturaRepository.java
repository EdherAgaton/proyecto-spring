package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
