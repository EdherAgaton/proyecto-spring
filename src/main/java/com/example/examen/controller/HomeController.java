package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.examen.model.Categoria;
import com.example.examen.model.Reloj;
import com.example.examen.service.IntCategoriaService;
import com.example.examen.service.IntRelojService;

@Controller
public class HomeController {
	
	@Autowired
	private IntRelojService relojService;
	
	@Autowired
	private IntCategoriaService categoriaService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		
		List<Reloj> listaR = relojService.listaR();
		List<Categoria> listaC = categoriaService.listaC();
		
		model.addAttribute("categorias", listaC);
		model.addAttribute("relojes", listaR);
		
		return "home";
		
	}

}
