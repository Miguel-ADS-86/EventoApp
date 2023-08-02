package com.miguelDev.EventoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
