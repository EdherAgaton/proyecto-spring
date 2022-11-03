package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.examen.model.Categoria;
import com.example.examen.model.Reloj;
import com.example.examen.service.IntCategoriaService;
import com.example.examen.service.util.Utileria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private IntCategoriaService categoriaService;
	
	
	@GetMapping("/lista")
	public String listar(Model model) {
		
		List<Categoria> listaCat = categoriaService.listaC();
		model.addAttribute("categorias", listaCat);
		
		return "categorias/lista";
		
	}
	
	
	@GetMapping("/eliminar")
	public String elimina (@RequestParam("id")int id, RedirectAttributes atributo) {
		
		categoriaService.eliminarC(id);
		atributo.addFlashAttribute("msg", "Categoria eliminada");
		
		return "redirect:/categorias/lista";
	}
	
	
	@GetMapping("/form")
	public String formulario(Categoria catergoria) {
		
		
		return "categorias/form";
		
	}
	
	@PostMapping("/guardar")
	public String crear(Categoria categoria, BindingResult br, RedirectAttributes atributo, Model model) {
		

		if(br.hasErrors()) {
			for(ObjectError error: br.getAllErrors()) {
				System.out.print("Error :" + error.getDefaultMessage());
				
			}
			model.addAttribute("categorias", categoriaService.listaC()); 
			return "relojes/form";
		}
		
	
		categoria.setId(categoriaService.listaC().size()+1);
		
		categoriaService.agregarC(categoria);
		
		atributo.addFlashAttribute("msg","Categoria Registrada");
		
		return "redirect:/categorias/lista";
	}
	
	
	
	
	

}
