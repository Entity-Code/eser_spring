package esercitazione.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import esercitazione.mvc.model.Corso;
import esercitazione.mvc.model.Studente;

@Repository
public interface StudenteRepository extends CrudRepository<Studente,Long> {

	public Studente findByMatricola(long matricola);
	
	public List<Studente> findAllBySesso(String sesso);
	
	public List<Studente> findAllByCorso(String corso);
	
	public void deleteByMatricola(long Matricola);
}
