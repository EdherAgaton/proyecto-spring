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

import com.example.examen.model.Tienda;
import com.example.examen.service.IntTiendaService;

@Controller
@RequestMapping("/tiendas")
public class TiendaController {
	
	
	@Autowired
	private IntTiendaService tiendaService;
	
	@GetMapping("/lista")
	public String listarTiendas(Model model) {
		
		List<Tienda> lista = tiendaService.listaT();
		model.addAttribute("tiendas", lista);
		
		
		return "tiendas/lista";
	}
	
	
	@GetMapping("/formulario")
	public String formTienda(Tienda tienda) {
		
		return "tiendas/form";
	}
	
	
	

	
	@GetMapping("/eliminar")
	public String eliminaMarca (@RequestParam("id")int id, RedirectAttributes atributo) {
		
		tiendaService.eliminarT(id);
		atributo.addFlashAttribute("msg", "Tienda eliminada");
		
		return "redirect:/tiendas/lista";
	}
	
	
	@GetMapping("/form")
	public String formulario(Tienda tienda) {
		
		
		return "tiendas/form";
		
	}
	
	@PostMapping("/guardar")
	public String crear(Tienda tienda, BindingResult br, RedirectAttributes atributo, Model model) {
		

		if(br.hasErrors()) {
			for(ObjectError error: br.getAllErrors()) {
				System.out.print("Error :" + error.getDefaultMessage());
				
			}
			model.addAttribute("marcas", tiendaService.listaT()); 
			return "tiendas/form";
		}
		
	
		//categoria.setId(categoriaService.listaC().size()+1);
		
		tiendaService.agregarT(tienda);
		
		atributo.addFlashAttribute("msg","Tienda Registrada");
		
		return "redirect:/tiendas/lista";
	}
	
	
	@GetMapping("/editar")
	public String editarCategoria(@RequestParam("id") int idTienda, Model model) {
		Tienda tienda = tiendaService.buscarT(idTienda);
		model.addAttribute("tienda", tienda);
		return "tiendas/form";
	}
	
	

}
