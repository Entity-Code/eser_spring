package esercitazione.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import esercitazione.mvc.model.Corso;
import esercitazione.mvc.model.Studente;
import esercitazione.mvc.repository.StudenteRepository;
import esercitazione.mvc.service.CorsoService;
import esercitazione.mvc.service.StudenteService;

@Controller
public class CorsoController {

	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private StudenteService studenteService;
	
	@Autowired
	private StudenteRepository studenteRepository;
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String presentazioneHome(Model model) {
		model.addAttribute("listaCorsi",corsoService.allCorsi());
		return "home";
	}
	
	@GetMapping("/visualizza/{nomeCorso}")
	public String visualizzaStudenti(@PathVariable(value="nomeCorso") String nomeCorso, Model model) {
		
//		Studente student = new Studente();

//		listaStudenti.addAll(studenteService.allStudenti());
		
		System.out.println(nomeCorso);
		System.out.println(studenteService.findStudenteByCorso(nomeCorso.toString()));
		
		model.addAttribute("listaStudenti", studenteService.findStudenteByCorso(nomeCorso.toString()));

		return "listaStudenti";
		

//		for(int i=0; i < corso.getLista().size(); i++) {
//			if(student.getCorso().equals(nomeCorso))
//				students.add(student);
//		}
//		System.out.println("SIZE LISTA CORSO = "+corso.getLista().size());
//
////		for(Corso c : corso) {
////			System.out.println(corso);
////		}
//		
//		System.out.println("CORSO = " +corso);
//		
//		for(Studente s:corso.getLista())
//			System.out.println("cognome"+s.getCognome());
//		
//		System.out.println(corso.getLista());
//		
		
	}
	
	//debug
	@RequestMapping("/visualizza")
	public ModelAndView firstPage() {
		System.out.println("arriva");
		return new ModelAndView("visualizza");
	}
	
	@RequestMapping(value="/aggiungi",method = RequestMethod.GET)
	public String aggiungiStudente(Model model) {
		model.addAttribute("listaCorsi",corsoService.allCorsi());
		return "aggiungistudente";
	}
	
//	@RequestMapping(value="/inserisci",method = RequestMethod.POST)
//	public String inserisciStudente(Model model,Studente studente,String nomeCorso) {
//		Corso corso=corsoService.getCorso(nomeCorso);
//		corso.getLista().add(studente);
//		studente.setCorso(corso);
//		studenteService.creaStudente(studente);
//		return "redirect:/home";
//	}
//	
}
