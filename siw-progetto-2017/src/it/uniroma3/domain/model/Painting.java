package it.uniroma3.domain.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
@NamedQuery(name="tuttiIQuadri",query="SELECT q FROM Quadro q"),
@NamedQuery(name="anniQuadri",query="SELECT DISTINCT q.annoRealizzazione FROM Quadro q")
})
@Entity
public class Painting {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private String tecnica;
	private String dimensioni;
	@ManyToOne(fetch=FetchType.EAGER)
	private Author autore;
	
	private byte[] immagine;
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
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public Integer getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public Author getAutore() {
		return autore;
	}
	public void setAutore(Author autore) {
		this.autore = autore;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public void setAnnoRealizzazione(Integer annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}
	
}