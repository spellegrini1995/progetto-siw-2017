package it.uniroma3.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "findAllAuthors", query = "SELECT a FROM Author a")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column
	private String nazionalità;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	private List<Painting> quadri;

	public Author(String nome, String cognome, String nazionalità, Date dataNascita, Date dataMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalità=nazionalità;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
		this.quadri = new ArrayList<>();
	}
	
	public Author(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalità() {
		return nazionalità;
	}

	public void setNazionalità(String nazionalità) {
		this.nazionalità = nazionalità;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Painting> getQuadri() {
		return quadri;
	}

	public void setQuadri(List<Painting> quadri) {
		this.quadri = quadri;
	}
	
	@Override
	public String toString(){
		return this.getNome()+""+this.getCognome();
	}
	
	
	
	
	
}
