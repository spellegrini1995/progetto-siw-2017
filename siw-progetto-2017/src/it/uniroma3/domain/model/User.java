package it.uniroma3.domain.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;


@Entity
@NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	private String numeroTelefono;

	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataRegistrazione;

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private Address address;

	public User(){}

	public User(String nome, String cognome, String email, String password, String numeroTelefono, Date dataNascita, Calendar dataRegistrazione, Address address) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.numeroTelefono = numeroTelefono;
		this.dataNascita = dataNascita;
		this.dataRegistrazione=dataRegistrazione;
		this.address=address;
	}
	
	public boolean checkPassword(String password){
		return this.password.equals(password);
	}

	//getters AND setters
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public Calendar getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Calendar dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome
				+ ", cognome=" + cognome + ", email=" + email
				+ ", numero cellulare=" + numeroTelefono + ", data nascita="
				+ dataNascita + ", indirizzo=" + address + ", password=" + password + "]";
	}
}