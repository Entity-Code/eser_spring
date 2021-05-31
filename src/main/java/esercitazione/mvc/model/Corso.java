package esercitazione.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="corsi")
public class Corso {

	@Id
	@Column(name="nome")
	private String nome;
	
	@Column(name="professore")
	private String professore;
	
	@Column(name="numerostudenti")
	private int numeroStudenti;
	
	@Column(name="sede")
	private String sede;
	
	@OneToMany(mappedBy="corso",cascade = CascadeType.ALL)
	List<Studente> lista=new ArrayList<Studente>();
	
	public Corso() {}

	public Corso(String nome, String professore, int numerostudenti, String sede) {
		this.nome = nome;
		this.professore = professore;
		this.numeroStudenti = numerostudenti;
		this.sede = sede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessore() {
		return professore;
	}

	public void setProfessore(String professore) {
		this.professore = professore;
	}

	public int getNumeroStudenti() {
		return numeroStudenti;
	}

	public void setNumeroStudenti(int numerostudenti) {
		this.numeroStudenti = numerostudenti;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<Studente> getLista() {
		return lista;
	}

	public void setLista(List<Studente> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Corso [nome=" + nome + ", professore=" + professore + ", numeroStudenti=" + numeroStudenti + ", sede="
				+ sede + ", lista=" + lista + "]";
	}
	
	
}
