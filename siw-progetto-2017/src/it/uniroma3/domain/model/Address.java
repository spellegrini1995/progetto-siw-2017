package it.uniroma3.domain.model;

import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String via;
	@Column(nullable = false)
	private String comune;
	private String provincia;
	@Column(nullable = false)
	private String codicePostale;
	@Column(nullable = false)
	private String nazione;
	
	public Address(){}
	
	public Address (String street, String city, String state, String zipcode, String country){
		this.via = street;
		this.comune = city;
		this.provincia = state;
		this.codicePostale = zipcode;
		this.nazione = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodicePostale() {
		return codicePostale;
	}

	public void setCodicePostale(String codicePostale) {
		this.codicePostale = codicePostale;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comune == null) ? 0 : comune.hashCode());
		result = prime * result + ((nazione == null) ? 0 : nazione.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
		result = prime * result + ((codicePostale == null) ? 0 : codicePostale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (comune == null) {
			if (other.comune != null)
				return false;
		} else if (!comune.equals(other.comune))
			return false;
		if (nazione == null) {
			if (other.nazione != null)
				return false;
		} else if (!nazione.equals(other.nazione))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		if (codicePostale == null) {
			if (other.codicePostale != null)
				return false;
		} else if (!codicePostale.equals(other.codicePostale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [via=" + via + ", comune=" + comune + ", provincia="
				+ provincia + ", codice postale=" + codicePostale + ", nazione=" + nazione + "]";
	}
	
	
}
