package com.bolsaideas.springbot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Usuario> usuarios = new ArrayList<>();
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listado";
	}
	
	
	

	
}
