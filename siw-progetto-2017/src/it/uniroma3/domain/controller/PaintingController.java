package it.uniroma3.domain.controller;

import java.util.List;

import it.uniroma3.domain.model.Painting;
import it.uniroma3.domain.facade.PaintingFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "paintingController")
public class PaintingController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private String tecnica;	
	private String dimensioni;
	private String autore;
	private Painting painting;
	
	private List<Painting> paintings;
	@EJB
	private PaintingFacade paintingFacade;

	public String deletePainting(){
		paintingFacade.deletePainting(id);
		this.paintings = paintingFacade.getAllPaintings();
		return "paintings";
	}

	public String updatePainting(){
		this.painting = paintingFacade.getPainting(id);

		return "update";
	}

	public String createPainting() {
		this.painting = paintingFacade.createPainting(titolo, tecnica, dimensioni);
		return "painting"; 
	}

	public String listPaintings() {
		this.paintings = paintingFacade.getAllPaintings();
		return "painting"; 
	}
	
	public String viewPaintings() {
		this.paintings = paintingFacade.getAllPaintings();
		return "viewPaintings"; 
	}
	
	public String orderPaintings() {
		this.paintings = paintingFacade.getAllPaintings();
		return "orderPaintings"; 
	}
	
	public String findPainting() {
		this.painting = paintingFacade.getPainting(id);
		return "painting";
	}

	public String findPainting(Long id) {
		this.painting = paintingFacade.getPainting(id);
		return "painting";
	}
	
	public Painting getByNamePainting(String titolo){
		this.painting = paintingFacade.getByNamePainting(titolo);
		return this.painting;
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

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting painting) {
		this.painting = painting;
	}

	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}

	public PaintingFacade getPaintingFacade() {
		return paintingFacade;
	}

	public void setPaintingFacade(PaintingFacade paintingFacade) {
		this.paintingFacade = paintingFacade;
	}
}