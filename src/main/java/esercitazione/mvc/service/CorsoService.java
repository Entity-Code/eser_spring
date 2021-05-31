package esercitazione.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esercitazione.mvc.model.Corso;
import esercitazione.mvc.repository.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	private CorsoRepository corsoRepository;
	
	public Corso creaCorso(Corso corso) {
		return corsoRepository.save(corso);
	}
	
	public Corso getCorso(String nome) {
		return corsoRepository.findByNome(nome);
	}
	
	public List<Corso>allCorsi(){
		List<Corso> list=new ArrayList<>();
		corsoRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	public void updateCorso(Corso corso) {
		corsoRepository.save(corso);
	}
	
	public void deleteCorso(String nome) {
		corsoRepository.deleteByNome(nome);
	}
}
