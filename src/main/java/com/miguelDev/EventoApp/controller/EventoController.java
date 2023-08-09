package com.miguelDev.EventoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miguelDev.EventoApp.model.Convidado;
import com.miguelDev.EventoApp.model.Evento;
import com.miguelDev.EventoApp.repository.ConvidadoRepository;
import com.miguelDev.EventoApp.repository.EventoRepository;

@Controller
public class EventoController {
    @Autowired
	private EventoRepository eventoRepository;
    
    @Autowired
    private ConvidadoRepository convidadoRepository;
	
    //Exibe a tela de cadastroEvento
	@GetMapping(value="/cadastro")
	public String getEvento() {
		return "paginas/cadastroEvento";
	}
	
	//Efetua o cadastro do evento
	@PostMapping(value="/cadastro")
	public String setEvento(Evento evento) {
	 	eventoRepository.save(evento);
	 	return "redirect:cadastro";
	}
	
	// enviando uma lista de eventos para a tela index
	@GetMapping(value="/cadastros")
	public ModelAndView listaEventos() {
		ModelAndView model = new ModelAndView("index");
		List<Evento> objs = eventoRepository.findAll();
		model.addObject("listaEventos", objs);
		return model;
	}
	// deletando evento
	@GetMapping(value="/deletarEvento")
	public String deletar(Long codigo) {
		Evento obj = eventoRepository.findById(codigo).get();
		eventoRepository.delete(obj);
		return "redirect:/cadastros";
	}
	
	// exibir detalhe evento com os seus respectivos convidados
	 @GetMapping(value = "{codigo}")
	 public ModelAndView exibirdetalhe(@PathVariable Long codigo) {
		 ModelAndView model = new ModelAndView("paginas/detalhe");
		 Evento evento = eventoRepository.findById(codigo).get();
		 List<Convidado> convidados = convidadoRepository.findByEvento(evento);
		 
		 model.addObject("detalheEvento", evento);
		 model.addObject("detalheConvidados",convidados);
		 
		 return model;
	 }
	 
	 // cadastrar um convidado no evento
	 @PostMapping(value="{codigo}")
	 public String cadastrarConvidado(@PathVariable Long codigo, Convidado convidado) {
		 Evento evento = eventoRepository.findById(codigo).get();
		 convidado.setEvento(evento);
		 convidadoRepository.save(convidado);
		 return "redirect:{codigo}";
	 }
	
}
