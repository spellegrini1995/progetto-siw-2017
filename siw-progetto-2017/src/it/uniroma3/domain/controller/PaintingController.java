package it.uniroma3.domain.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import it.uniroma3.domain.facade.PaintingFacade;
import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;



@ManagedBean(name="paintingController")
public class PaintingController {
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private String dimensioni;
	private String tecnica;
	private Author autore;
	private String nomeAutore;
	private Part immagine;
	private Painting operaCorrente;
	private List<Painting> opere;
	private List<Painting> opereResult;
	//occorre perch� nella form specifico l'autore e ne acquisisco l'id
	private Long idAutore;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	@EJB(beanName="paintingFacade")
	private PaintingFacade paintingFacade;


	public String salvaQuadro() {
		byte[] tmp = this.converti(immagine);
		operaCorrente = paintingFacade.salva(titolo, annoRealizzazione, dimensioni,tecnica,idAutore,tmp);
		return "datiQuadro";
	}

	public List<Painting> getOpere(){
		this.opere=paintingFacade.getAll();
		return this.opere;
	}
	public String visualizzaOpera(Long id){
		this.operaCorrente=paintingFacade.find(id);
		return "datiQuadro";
	}
	public String vediOpera(String titolo){
		this.operaCorrente=paintingFacade.getPaintingByTitolo(titolo);
		return "datiQuadro";
	}
	public String cancellaOpera(Long id){
		this.paintingFacade.remove(id);
		return "listaQuadri";
	}

	public String viewPaintings() {
		this.opere = paintingFacade.getAll();
		this.setOpere(opere);
		return "listaQuadri";
	}			
	public String searchPaintings() {
		this.opere = paintingFacade.getAll();
		this.setOpere(opere);
		return "ricercaQuadri";
	}		
	public String selezionaAutore() {
		return "selezionaAutore";
	}	
	public String selezionaAnno() {
		return "selezionaAnno";
	}	
	public String selezionaTecnica() {
		return "selezionaTecnica";
	}

	public String setAuthor(){
		this.setAutore(autore);
		return "listaQuadri";
	}
	public List<Integer> listaAnni(){
		return paintingFacade.listaAnni();
	}
	
	public List<String> listaTecniche(){
		return paintingFacade.listaTecniche();
	}
	
	public String nullAuthor() {
		this.autore=null;
		this.setAutore(autore);
		return "listaQuadri";
	}
	public String visualizzaQuadriAnno(Integer anno){
		this.setOpereResult(paintingFacade.getPaintingsByAnno(anno));
		return "listaQuadriResult";
	}	
	public String visualizzaQuadriTecnica(String tecnica){
		this.setOpereResult(paintingFacade.getPaintingsByTecnica(tecnica));
		return "listaQuadriResult";
	}
	public String visualizzaQuadriAutore(Long id){
		this.setOpereResult(this.paintingFacade.getAuthorPaintings(id));
		return "listaQuadriResult";
	}
	private byte[] converti(Part file){
		byte[] res;
		try{
			InputStream is = file.getInputStream();
			byte[] buffer = new byte[(int)file.getSize()];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			for (int length=0;(length=is.read(buffer))>0;) 
				output.write(buffer,0,length);
			res=output.toByteArray();
		} catch (IOException | NullPointerException e) {
			res=new byte[0];
		}
		return res;
	}
	public String modificaQuadro(Long id){
		this.operaCorrente=paintingFacade.find(id);
		this.sessionMap.put("editQuadro",operaCorrente);
		return "modificaQuadro";
	}
	public String updateQuadro(Painting q){
		byte[] nuovaImm=this.converti(this.immagine);
		if(nuovaImm.length>0)
			q.setImmagine(nuovaImm);
		this.paintingFacade.merge(q, idAutore);
		this.sessionMap.remove("editQuadro");
		return "listaQuadri";
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
	public Author getAutore() {
		return autore;
	}
	public void setAutore(Author autore) {
		this.autore = autore;
	}
	public Painting getOperaCorrente() {
		return operaCorrente;
	}
	public void setOperaCorrente(Painting quadroCorrente) {
		this.operaCorrente = quadroCorrente;
	}
	public PaintingFacade getPaintingFacade() {
		return paintingFacade;
	}
	public void setPaintingFacade(PaintingFacade paintingFacade) {
		this.paintingFacade = paintingFacade;
	}
	public Long getId() {
		return id;
	}
	public Long getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}
	public void setOpere(List<Painting> opere) {
		this.opere = opere;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public Part getImmagine() {
		return immagine;
	}
	public void setImmagine(Part immagine) {
		this.immagine = immagine;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public String getNomeAutore() {
		return nomeAutore;
	}
	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public List<Painting> getOpereResult() {
		return opereResult;
	}

	public void setOpereResult(List<Painting> opereResult) {
		this.opereResult = opereResult;
	}
	

}