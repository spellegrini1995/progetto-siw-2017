package it.uniroma3.domain.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import it.uniroma3.domain.facade.UserFacade;
import it.uniroma3.domain.model.User;

@ManagedBean(name="userController")
@SessionScoped
public class UserController {

@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String numeroTelefono;
	private Date dataNascita;
	private Calendar dataRegistrazione;
	
	//campi per l'indirizzo
	private String via,comune,nazione,codicePostale,provincia;
	
	private List<User> users; //tutti gli utenti registrati nel sistema
	private User currentUser; //utente corrente

	@EJB(beanName="userFacade")
	private UserFacade userFacade;
	

	public String createUser() {
		try{
			/*Genera automaticamente la data di oggi */
			this.dataRegistrazione = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
			this.currentUser = userFacade.createUser(nome, cognome,email,password,numeroTelefono,dataNascita,dataRegistrazione,via,comune,provincia,codicePostale,nazione);
			return "registrationDone";
		}catch(Exception e){
			/*Utente già registrato*/
			this.resetUser();
			FacesContext.getCurrentInstance().addMessage("registrationCustomer:signinCustomer", new FacesMessage("Utente già registrato!"));
			return "customerRegistration";
		}
	}

	public String loginUser() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("administratorController");
		try{
			User user = userFacade.getUserByEmail(email);
			if (user.checkPassword(this.password)) {
				setCurrentUser(user);
				return "customerPage";
			}
			else{
				// Password Errata
				FacesContext.getCurrentInstance().addMessage("loginCustomer:accedi", new FacesMessage("Login Errato! Email o password non inseriti correttamente!"));
				return "login";
			}
		}
		catch (Exception e) {
			// Cliente non trovato
			FacesContext.getCurrentInstance().addMessage("loginCustomer:accedi", new FacesMessage("Login Errato! Email o password non inseriti correttamente!"));
			return "login";
		}
	}

	public String logoutUser() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}

	private void resetUser(){
		this.nome = null;
		this.cognome = null;
		this.password = null;
		this.email = null;
		this.numeroTelefono = null;
		this.via = null;
		this.comune = null;
		this.provincia = null;
		this.codicePostale = null;
		this.nazione = null;
		this.dataNascita = null;
		this.dataRegistrazione = null;
	}

	public String listUsers() {
		this.users = userFacade.getAllUsers();
		return "allUsers";
	}

	public String findUser() {
		this.currentUser = userFacade.getUser(this.email);
		return "userInfo";
	}

	public String findUser(String email) {
		this.currentUser = userFacade.getUser(email);
		return "userInfo";
	}
	
	public String logout (){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
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

	public Calendar getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Calendar dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
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

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getCodicePostale() {
		return codicePostale;
	}

	public void setCodicePostale(String codicePostale) {
		this.codicePostale = codicePostale;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}	
}
