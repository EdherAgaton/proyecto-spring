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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.examen.model.Marca;
import com.example.examen.service.IntMarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private IntMarcaService marcaService;
	
	@GetMapping("/lista")
	public String listarMarcas(Model model) {
		
		List<Marca> lista = marcaService.listaM();
		model.addAttribute("marcas", lista);
		
		
		return "marcas/lista";
	}
	
	
	@GetMapping("/formulario")
	public String formMarca(Marca marca) {
		
		return "marcas/form";
	}
	
	
	

	
	@GetMapping("/eliminar")
	public String eliminaMarca (@RequestParam("id")int id, RedirectAttributes atributo) {
		
		marcaService.eliminarM(id);
		atributo.addFlashAttribute("msg", "Marca eliminada");
		
		return "redirect:/marca/lista";
	}
	
	
	@GetMapping("/form")
	public String formulario(Marca marca) {
		
		
		return "marcas/form";
		
	}
	
	@PostMapping("/guardar")
	public String crear(Marca marca, BindingResult br, RedirectAttributes atributo, Model model) {
		

		if(br.hasErrors()) {
			for(ObjectError error: br.getAllErrors()) {
				System.out.print("Error :" + error.getDefaultMessage());
				
			}
			model.addAttribute("marcas", marcaService.listaM()); 
			return "marcas/form";
		}
		
	
		//categoria.setId(categoriaService.listaC().size()+1);
		
		marcaService.agregarM(marca);
		
		atributo.addFlashAttribute("msg","Marca Registrada");
		
		return "redirect:/marca/lista";
	}
	
	
	@GetMapping("/editar")
	public String editarCategoria(@RequestParam("id") int idMarca, Model model) {
		Marca marca = marcaService.buscarM(idMarca);
		model.addAttribute("marca", marca);
		return "marcas/form";
	}
	
	
	
	

}
