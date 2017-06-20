package it.uniroma3.domain.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;
import it.uniroma3.domain.facade.AuthorFacade;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "authorController")
public class AuthorController {

	@ManagedProperty(value="#{param.id}")
	private Long id;

	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	private Author author;
	private List<Painting> quadri;
	private List<Author> autori;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


	@EJB(beanName="authorFacade")
	private AuthorFacade authorFacade;

	public String createAuthor() {
		try{
			this.author= authorFacade.createAuthor(nome,cognome,nazionalita,dataNascita,dataMorte);
			this.setAuthor(author);;
			return "datiAutore"; 			
		}catch(Exception e){
			/*Autore gi� registrato*/
			this.resetAuthor();
			FacesContext.getCurrentInstance().addMessage("newAuthor:createAuthor", new FacesMessage("Autore gia registrato!"));
			return "inserimentoNuovoAutore";
		}
	}

	private void resetAuthor(){
		this.nome = null;
		this.cognome = null;
		this.nazionalita = null;
		this.dataNascita = null;
		this.dataMorte = null;
	}

	public String listPaintings() throws IOException {
		this.quadri = author.getQuadri();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/listaQuadri.xhtml");
		return "listaQuadri"; 
	}

	public List<String> listaNazioni(){
		return authorFacade.listaNazioni();
	}

	public String findAuthor() throws IOException {
		this.author = authorFacade.getAuthor(id);
		setAuthor(author);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/datiAutore.xhtml");
		return "datiAutore";
	}
	public String cancellaAutore(Long id) throws IOException{
		this.authorFacade.deleteAuthor(id);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/listaAutori.xhtml");
		return "listaAutori";
	}
	public List<Author> getAll(){
		return authorFacade.getAllAuthors();
	}	
	public String findAuthor(Long id) throws IOException {
		this.author = authorFacade.getAuthor(id);
		setAuthor(author);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/datiAutore.xhtml");
		return "datiAutore";
	}	
	public String viewAuthors() throws IOException {
		this.autori = authorFacade.getAllAuthors();
		this.setAutori(autori);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/listaAutori.xhtml");
		return "listaAutori";
	}	
	public String viewAuthor(String nome, String cognome) {
		this.author = authorFacade.getAuthor(nome, cognome);
		this.setAuthor(author);
		return "datiAutore";
	}

	public Author getByNameAuthor(String nome, String cognome){
		this.author = authorFacade.getByNameAuthor(nome, cognome);
		return this.author;
	}

	public String iniziaModifica(Long id) throws IOException{
		Author scelto=authorFacade.getAuthor(id);
		this.sessionMap.put("editAutore",scelto);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/modificaAutore.xhtml");
		return "modificaAutore";
	}
	public String modificaAutore(Author a) throws IOException{
		this.authorFacade.updateAuthor(a);
		this.sessionMap.remove("editAutore");
		FacesContext.getCurrentInstance().getExternalContext().redirect("/siw-progetto-2017/listaAutori.xhtml");
		return "listaAutori";
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

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
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
		this.autori = authorFacade.getAllAuthors();
		return autori;
	}

	public void setAutori(List<Author> autori) {
		this.autori = autori;
	}
}