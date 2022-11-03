package com.example.examen.model;

import java.time.LocalDate;

public class Factura {

	private int id;
	private String titular;
	private double cantidad;
	private LocalDate fecha;
	private Reloj reloj;
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Reloj getReloj() {
		return reloj;
	}

	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", titular=" + titular + ", cantidad=" + cantidad + ", reloj=" + reloj + "]";
	}

}
