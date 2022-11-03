package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.examen.model.Factura;
import com.example.examen.service.IntFacturaService;


@Controller
@RequestMapping("/facturas")
public class FacturaController {
	
	@Autowired
	private IntFacturaService facturaService;
	
	
	@GetMapping("/lista")
	public String listarFac (Model model) {
		
		List<Factura> listaFacturas = facturaService.listaF();
		model.addAttribute("facturas", listaFacturas);
		
		return "facturas/lista";
		
	}
	
	@GetMapping("/detalle")
	public String detalles(Model model,@RequestParam("id")int id) {
		
	
		
	model.addAttribute("factura", facturaService.buscarF(id));
		
		return "facturas/detalle";
		
	}
		
	
	
	

}
