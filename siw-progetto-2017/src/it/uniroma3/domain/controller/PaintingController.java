package it.uniroma3.domain.controller;

import java.util.List;

import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;
import it.uniroma3.domain.facade.AuthorFacade;
import it.uniroma3.domain.facade.PaintingFacade;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean(name = "paintingController")
public class PaintingController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private String tecnica;	
	private String dimensioni;
	private Author autore;
	private String nomeAutore;
	private List<Painting> paintings;
	private Long idAuthor;

	@ManagedProperty(value="#{sessionScope['authorsPainting']}")
	private List<Author> authors;

	@ManagedProperty(value="#{sessionScope['currentPainting']}")
	private Painting painting;

	@EJB(beanName="paintingFacade")
	private PaintingFacade paintingFacade;

	@EJB(beanName="authorFacade")
	private AuthorFacade authorFacade;

	public String createPainting() {
		try{
			this.autore = authorFacade.getAuthor(this.nomeAutore);
			this.painting = paintingFacade.createPainting(titolo,annoRealizzazione,tecnica,dimensioni,autore);
			this.autore.getQuadri().add(painting);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentPainting", this.painting);
			return "datiQuadro";
		}catch(Exception e){
			/*id quadro gia esistente nel DB*/
			this.resetPainting();
			FacesContext.getCurrentInstance().addMessage("newPainting:createPainting", new FacesMessage("Codice Quadro gia esistente!"));
			return "inserimentoQuadro";
		}
	}

	public String updatePainting() {
		try{
			paintingFacade.updatePainting(this.painting);
			return "datiQuadro";
		}catch(Exception e){
			return "inserimentoQuadro";
		}
	}


	public String setAuthor() {
		this.autore = authorFacade.getAuthor(this.nomeAutore);
		this.painting.setAutore(autore);
		paintingFacade.updatePainting(this.painting);
		authorFacade.updateAuthor(this.autore);
		return "modificaQuadro";
	}

	private void resetPainting(){
		this.titolo=null;
		this.annoRealizzazione=null;
		this.tecnica=null;
		this.dimensioni=null;
		this.autore=null;
	}

	public String nullAuthor() {
		this.autore = null;
		this.painting.setAutore(autore);
		paintingFacade.updatePainting(this.painting);
		return "modificaQuadro";
	}

	public String deletePainting(){
		paintingFacade.deletePainting(id);
		this.paintings = paintingFacade.getAllPaintings();
		return "listaQuadri";
	}

	public String findPainting() {
		this.painting = paintingFacade.getPainting(id);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentPainting", this.painting);
		return "datiQuadro";
	}

	public String findPainting(Long id) {
		this.painting = paintingFacade.getPainting(id);
		return "datiQuadro";
	}	

	public String viewPaintings() {
		try{
			this.paintings = paintingFacade.getAllPaintings();
			this.setPaintings(paintings);
			return "listaQuadri";
		}
		catch(Exception e){
			return "index";
		}
	}

	//getter and setter
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

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting painting) {
		this.painting = painting;
	}

	public PaintingFacade getPaintingFacade() {
		return paintingFacade;
	}

	public void setPaintingFacade(PaintingFacade paintingFacade) {
		this.paintingFacade = paintingFacade;
	}

	public AuthorFacade getAuthorFacade() {
		return authorFacade;
	}

	public void setAuthorFacade(AuthorFacade authorFacade) {
		this.authorFacade = authorFacade;
	}
	
	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

}