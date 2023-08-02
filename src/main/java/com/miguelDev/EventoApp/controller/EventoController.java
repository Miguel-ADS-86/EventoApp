package com.miguelDev.EventoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.miguelDev.EventoApp.model.Evento;
import com.miguelDev.EventoApp.repository.EventoRepository;

@Controller
public class EventoController {
    @Autowired
	private EventoRepository eventoRepository;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String getEvento() {
		return "paginas/cadastroEvento";
	}
	
	@RequestMapping(value="cadastro", method = RequestMethod.POST)
	public String setEvento(Evento evento) {
	 	eventoRepository.save(evento);
	 	return "redirect:cadastro";
	}
	
	// enviando uma lista de eventos para a tela index
	@RequestMapping(value="cadastros", method = RequestMethod.GET)
	public ModelAndView listaEventos() {
		ModelAndView model = new ModelAndView("index");
		List<Evento> objs = eventoRepository.findAll();
		model.addObject("listaEventos", objs);
		return model;
	}
}
