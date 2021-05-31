package esercitazione.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import esercitazione.mvc.model.Studente;
import esercitazione.mvc.repository.StudenteRepository;

@Service
public class StudenteService {
	
	private StudenteRepository studenteRepository;
	
	@Autowired
	public StudenteService(StudenteRepository studenteRepository) {
		this.studenteRepository = studenteRepository;
	}
	
	public Studente creaStudente(Studente studente) {
		return studenteRepository.save(studente);
	}
	
	public Studente getStudente(long matricola) {
		return studenteRepository.findByMatricola(matricola);
	}
	
	public List<Studente> findStudenteByCorso(String nomeCorso) {
		
		return studenteRepository.findAllByCorso(nomeCorso);
	}
	
	public List<Studente>allStudenti(){
		List<Studente> list=new ArrayList<>();
		studenteRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	public void updateStudente(Studente studente) {
		studenteRepository.save(studente);
	}
	
	public void deleteStudente(long matricola) {
		studenteRepository.deleteByMatricola(matricola);
	}
}