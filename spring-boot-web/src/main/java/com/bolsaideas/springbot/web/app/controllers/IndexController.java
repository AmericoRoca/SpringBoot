package com.bolsaideas.springbot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springbot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Americo");
		usuario.setApellido("Chiclana");
		usuario.setEmail("asdawd");
		
		model.addAttribute("usuario", usuario );
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
		model.addAttribute("correo", "El correo es: ".concat(usuario.getEmail()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		

		
		model.addAttribute("titulo", "Lista de usuarios");
		return "listado";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(new Usuario("Americo", "Chiclana", "achiclana@java.com"),
				new Usuario("Jesus", "Gomez", "jgomez@java.com"),
				new Usuario("Paco", "Liso", "pliso@java.com"),
				new Usuario("Rocky", "Balboa", "rbalboa@java.com"));
		
		return usuarios;
	}
	
	
	

	
}
