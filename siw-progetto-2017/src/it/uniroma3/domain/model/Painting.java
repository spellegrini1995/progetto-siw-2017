package it.uniroma3.domain.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="tuttiIQuadri",query="SELECT q FROM Painting q"),
	@NamedQuery(name="anniQuadri",query="SELECT DISTINCT q.annoRealizzazione FROM Painting q"),
	@NamedQuery(name="quadriPerAnno",query="SELECT DISTINCT q FROM Painting q WHERE q.annoRealizzazione = :anno"),
	@NamedQuery(name="quadriPerTecnica",query="SELECT DISTINCT q FROM Painting q WHERE q.tecnica = :tecnica"),
	@NamedQuery(name="tecnicheQuadri",query="SELECT DISTINCT q.tecnica FROM Painting q")})
 
@Entity
public class Painting {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String titolo;
	@Column
	private Integer annoRealizzazione;
	@Column
	private String tecnica;
	@Column
	private String dimensioni;
	@Column
	@ManyToOne(fetch=FetchType.EAGER)
	private Author autore;
	@Column
	private byte[] immagine;

	public Painting(String titolo, Integer anno, String tecnica, String dimensioni) {
		this.titolo = titolo;
		this.annoRealizzazione = anno;
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
	}

	public Painting() {
		// TODO Auto-generated constructor stub
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