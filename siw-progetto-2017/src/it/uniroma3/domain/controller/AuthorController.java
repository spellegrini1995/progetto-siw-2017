package it.uniroma3.domain.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;
import it.uniroma3.domain.facade.AuthorFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "authorController")
public class AuthorController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private String nome;
	private String cognome;
	private String nazionalità;
	private Date dataNascita;
	private Date dataMorte;
	private Author author;
	private List<Painting> quadri;
	private List<Author> autori;

	@EJB(beanName="authorFacade")
	private AuthorFacade authorFacade;

	public String createAuthor() {
		this.author = authorFacade.createAuthor(nome,cognome,nazionalità,dataNascita,dataMorte);
		return "datiAutore"; 
	}

	public String listPaintings() {
		this.quadri = author.getQuadri();
		return "listaQuadri"; 
	}
	
	public String findAuthor() {
		this.author = authorFacade.getAuthor(id);
		return "datiAutore";
	}

	public String findAuthor(Long id) {
		this.author = authorFacade.getAuthor(id);
		return "datiAutore";
	}	
	public String viewAuthors() {
		this.autori = authorFacade.getAllAuthors();
		return "listaAutori";
	}
	
	public Author getByNameAuthor(String nome, String cognome){
		this.author = authorFacade.getByNameAuthor(nome, cognome);
		return this.author;
	}
	
	//getter and setter

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public AuthorFacade getAuthorFacade() {
		return authorFacade;
	}

	public void setAuthorFacade(AuthorFacade authorFacade) {
		this.authorFacade = authorFacade;
	}

	public List<Painting> getQuadri() {
		return quadri;
	}

	public void setQuadri(List<Painting> quadri) {
		this.quadri = quadri;
	}

	public List<Author> getAutori() {
		return autori;
	}

	public void setAutori(List<Author> autori) {
		this.autori = autori;
	}
}