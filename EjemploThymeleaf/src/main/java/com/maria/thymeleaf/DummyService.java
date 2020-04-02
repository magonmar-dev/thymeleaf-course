package com.maria.thymeleaf;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
	
	private List<Producto> lista;

	public Producto getProducto() {
		return new Producto("Camiseta oficial de Openwebinars","¡No puedes dejar de tenerla! Se trata de la camiseta oficial de Openwebinars. Aquella que usan todos los programadores que han aprendido cualquier lenguaje de programación con alguno de nuestros cursos. ¿Te vas a quedar sin ella? Será la moda esta temporada :)",15.0f, 87, 91.1f);
	}
	
	public Producto getProductoSinAlgunosValores() {
		return new Producto("Otro producto", null, 1.0f);
	}
	
	/*
	 * public List<Producto> getLista() { 
	 * 	return Arrays.asList( 
	 * 		new Producto("Producto 1", "Descripción 1", 1.0f), 
	 * 		new Producto("Producto 2", "Descripción 2", 2.0f), 
	 * 		new Producto("Producto 3", "Descripción 3", 3.0f) 
	 * 	);
	 * }
	 */
	
	/*
	 * public Map<String, Producto> getMap() { 
	 * 	return Collections.singletonMap("p4", new Producto("Producto 4", "Descripción 4", 4.0f)); 
	 * }
	 */
	
	@PostConstruct
	private void init() {
		lista = Arrays.asList(
				new Producto("Producto 1", "Descripción 1", 1.0f),
				new Producto("Producto 2", "Descripción 2", 2.0f),
				new Producto("Producto 3", "Descripción 3", 3.0f)
				);
	}
	
	public List<Producto> getLista() {
		return lista;
	}
	
	public Producto[] getArray() {
		return (Producto[])(lista.toArray());
	}
	
	public Collection<Producto> getCollection() {
		return lista;
	}
	
	public Set<Producto> getSet() {
		Set<Producto> set = new HashSet<Producto>();
		set.addAll(lista);
		return set;
	}
	
	public Map<Producto, Integer> getMap() {
		Map<Producto, Integer> map = new HashMap<Producto, Integer>();
		
		for(int i=0; i < lista.size();i++) {
			map.put(lista.get(i), i+1);
		}
		
		return map;
	}
}