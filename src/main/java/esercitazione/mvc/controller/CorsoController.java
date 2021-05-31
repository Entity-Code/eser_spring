package esercitazione.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import esercitazione.mvc.model.Corso;
import esercitazione.mvc.model.Studente;
import esercitazione.mvc.service.CorsoService;
import esercitazione.mvc.service.StudenteService;

@Controller
public class CorsoController {

	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private StudenteService studenteService;
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String presentazioneHome(Model model) {
		model.addAttribute("listaCorsi",corsoService.allCorsi());
		return "home";
	}
	
	@RequestMapping(value="/visualizza/{nomeCorso}",method = RequestMethod.GET)
	public String visualizzaStudenti(@PathVariable(value="nomeCorso")String nomeCorso,Model model) {
		System.out.println(nomeCorso);
		Corso corso=corsoService.getCorso(nomeCorso);
		for(Studente s:corso.getLista())
			System.out.println("cognome"+s.getCognome());
		model.addAttribute("listaStudenti",corso.getLista());
		return "listaStudenti";
	}
	
	@RequestMapping(value="/aggiungi",method = RequestMethod.GET)
	public String aggiungiStudente(Model model) {
		model.addAttribute("listaCorsi",corsoService.allCorsi());
		return "aggiungistudente";
	}
	
	@RequestMapping(value="/inserisci",method = RequestMethod.POST)
	public String inserisciStudente(Model model,Studente studente,String nomeCorso) {
		Corso corso=corsoService.getCorso(nomeCorso);
		corso.getLista().add(studente);
		studente.setCorso(corso);
		studenteService.creaStudente(studente);
		return "redirect:/home";
		
	}
	
}
