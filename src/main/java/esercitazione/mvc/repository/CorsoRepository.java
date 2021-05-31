package esercitazione.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import esercitazione.mvc.model.Corso;

@Repository
public interface CorsoRepository extends CrudRepository<Corso,String> {

	public Corso findByNome(String nome);
	
	public void deleteByNome(String nome);
}
