package it.uniroma3.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllPaintings", query = "SELECT p FROM Painting p")
public class Painting {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String titolo;
	@Column
	private Integer annoRealizzazione;
	@Column(nullable=false)
	private String tecnica;	
	@Column
	private String dimensioni;
	
	@Column
	@ManyToOne
	private Author autore;
	
	public Painting(String titolo, Integer annoRealizzazione, String tecnica, String dimensioni, Author autore) {
		this.titolo = titolo;
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
		this.annoRealizzazione = annoRealizzazione;
		this.autore=autore;
	}	
	public Painting() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(Integer annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Author getAutore() {
		return autore;
	}

	public void setAutore(Author autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString(){
		return this.getTitolo();
	}
	
	
}
