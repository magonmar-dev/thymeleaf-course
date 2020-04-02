package com.maria.thymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private DummyService service;

	@GetMapping({ "/", "/welcome" })
	public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {
		// http://localhost:8080/?nombre=maria
		model.addAttribute("nombre", nombre);
		model.addAttribute("saludo", "Un saludo para todos los programadores del mundo");
		model.addAttribute("boton", "Ir a...");
		model.addAttribute("mensaje",
				"<strong>Sed bienvenidos todos aquellos que tengáis ganas de aprender a desarrollar aplicaciones web usando <em>Thymeleaf</em></strong>");
		return "index";
	}

	@GetMapping("/producto/{id}")
	public String verProducto(Model model) {
		Producto producto = new Producto("Camiseta oficial de Openwebinars",
				"¡No puedes dejar de tenerla! Se trata de la camiseta oficial de Openwebinars. Aquella que usan todos los programadores que han aprendido cualquier lenguaje de programación con alguno de nuestros cursos. ¿Te vas a quedar sin ella? Será la moda esta temporada :)",
				15.0f, 87, 91.1f);
		model.addAttribute("producto", producto);
		return "producto";
	}

	@GetMapping("/expresiones")
	public String expresiones(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", nombre);
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", new Date());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());

		return "expresiones";
	}

	@GetMapping("/operadores")
	public String operadores(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {
		// Funciona igual que en ejemplos anteriores
		model.addAttribute("nombre", nombre);
		// Tomamos la fecha y hora actual del sistema
		model.addAttribute("today", new Date());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores
		model.addAttribute("producto2", service.getProductoSinAlgunosValores());

		return "operadores";
	}
	
	@GetMapping({"/colecciones","/list"})
	public String list(@RequestParam(name="iterstat", required=false, defaultValue="no") String iterstat, Model model) {
		model.addAttribute("productos", service.getLista());
		if (iterstat.equalsIgnoreCase("no"))
			return "colecciones";
		else
			return "stat";
	}
	
	@GetMapping({"/array"})
	public String array(Model model) {
		model.addAttribute("productos", service.getArray());		
		return "colecciones";
	}
	
	@GetMapping({"/collection"})
	public String collection(Model model) {	
		model.addAttribute("productos", service.getCollection());		
		return "colecciones";
	}

	@GetMapping({"/set"})
	public String set(Model model) {	
		model.addAttribute("productos", service.getSet());		
		return "colecciones";
	}
	

	@GetMapping({"/map"})
	public String map(Model model) {	
		model.addAttribute("carrito", service.getMap());		
		return "map";
	}
}
