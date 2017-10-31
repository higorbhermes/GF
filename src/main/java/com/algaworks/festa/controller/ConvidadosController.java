package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;
	
	@GetMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		List <Convidado> lista = convidados.findAll();
		mv.addObject("convidados",lista);
		mv.addObject(new Convidado());
		return mv;
	}

	@PostMapping("/convidados")
	public String salvar(Convidado c) {
		convidados.save(c);
		return "redirect:/convidados";

	}


}
