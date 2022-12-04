package com.example.examen.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.examen.model.Reloj;
import com.example.examen.service.IntCategoriaService;
import com.example.examen.service.IntMarcaService;
import com.example.examen.service.IntRelojService;
import com.example.examen.service.IntTiendaService;

@Controller
@RequestMapping("/reloj")
public class RelojController {
	
	@Autowired
	private IntRelojService relojService;
	
	@Autowired
	private IntCategoriaService categoriaService;
	
	@Autowired
	private IntMarcaService marcaService;
	
	
	@Autowired
	private IntTiendaService tiendaService;
	
	
	@GetMapping("/lista")
	public String lista(Model model) {
		
		List<Reloj> relojes = relojService.listaR();
		model.addAttribute("relojes", relojes);
		
		return "relojes/lista";
		
	}
	
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Reloj>lista = relojService.listarR(page);
	model.addAttribute("relojes", lista);
	return "relojes/lista";
	}
	
	@GetMapping("/form")
	public String formulario(Model model, Reloj reloj) {
		
		model.addAttribute("categorias", categoriaService.listaC());
		model.addAttribute("marcas", marcaService.listaM());
		model.addAttribute("tiendas", tiendaService.listaT());
		
		return "relojes/form";
	}
	
	@PostMapping("/guardar")
	public String guardarReloj(Reloj reloj, BindingResult br, RedirectAttributes atributo, @RequestParam("archivoImagen") MultipartFile multiPart, Model model) {
		
		if(br.hasErrors()) {
			for(ObjectError error: br.getAllErrors()) {
				System.out.print("Error :" + error.getDefaultMessage());
				
			}
			model.addAttribute("categorias", categoriaService.listaC()); 
			return "relojes/form";
		}
		
		System.out.print(reloj);
		//reloj.setId(relojService.listaR().size()+1);
		System.out.print(reloj);
	
		if (!multiPart.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main//resources//static/imagenes");
            String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg= multiPart.getBytes();
				Path rutaCompleta=Paths.get(rutaAbsoluta + "//" + multiPart.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				reloj.setImagen(multiPart.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			/*
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			String ruta = "c:/relojes/img-relojes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			reloj.setImagen(nombreImagen);
			}
			}
			
			*/
		relojService.agregarR(reloj);
		atributo.addFlashAttribute("msg","Reloj Registrado");
		
		
		return "redirect:/reloj/indexPaginate";
		
		
	}
	
	@GetMapping("/eliminar")
	public String eliminarcion(@RequestParam("id")int id, RedirectAttributes atributo) {
		
		relojService.eliminarR(id);
		atributo.addFlashAttribute("msg", "Reloj eliminado");
		
		return "redirect:/reloj/indexPaginate";
		
	}
	
	
	@GetMapping("/detalle")
	public String detalles(@RequestParam("id")int id, Model model) {
		
		
		
		
		model.addAttribute("reloj",relojService.buscarR(id) );
		model.addAttribute("categoria", categoriaService.buscarC(id));
		model.addAttribute("tiendas", tiendaService.buscarT(id));
		
		return "relojes/detalle";
		
	}
	
	
	
	
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException{
				setValue(LocalDate.parse(text,DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				
			}
			@Override
			
			public String getAsText()throws IllegalArgumentException{
				return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate)getValue());
			}
			
			
		});
	}
	
	
	

	@GetMapping("/editar")
	public String editarReloj(@RequestParam("id") int idReloj, Model model) {
		Reloj reloj = relojService.buscarR(idReloj);
		model.addAttribute("categorias", categoriaService.listaC());
		model.addAttribute("marcas", marcaService.listaM());
		model.addAttribute("reloj", reloj);
		return "relojes/form";
	}

	
	
	
	
	

}
