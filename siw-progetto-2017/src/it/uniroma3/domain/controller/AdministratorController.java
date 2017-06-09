package it.uniroma3.domain.controller;

import java.util.ArrayList;
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

import it.uniroma3.domain.facade.AdministratorFacade;
import it.uniroma3.domain.facade.AuthorFacade;
import it.uniroma3.domain.facade.PaintingFacade;
import it.uniroma3.domain.facade.UserFacade;
import it.uniroma3.domain.model.Administrator;
import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;

@ManagedBean(name="administratorController")
@SessionScoped
public class AdministratorController {

	/*Dati per la registrazione di un nuovo utente da parte dell'amministratore */
	private String firstName, lastName, passwordUser, email, phoneNumber, street, city, country, zipcode, state;
	private Date dateOfBirth;
	private Calendar registrationDate;
	
	private String nome;
	private String cognome;
	private String nickname;
	private String password;
	private Administrator currentAdministrator;
	
	private String message;
	
	@ManagedProperty(value="#{currentPainting}")
	private Painting painting;
	
	@ManagedProperty(value="#{authorsPainting}")
	private List<Author> authors;

	@EJB(beanName="administratorFacade")
	private AdministratorFacade administratorFacade;
	
	@EJB(beanName="userFacade")
	private UserFacade userFacade;	
	
	@EJB(beanName="authorFacade")
	private AuthorFacade authorFacade;
	
	@EJB(beanName="paintingFacade")
	private PaintingFacade paintingFacade;
	
	public String createAdministrator() {
		this.currentAdministrator = administratorFacade.createAdministrator(nome,cognome,nickname, password);
		return "administratorHome";
	}
	
	public String loginAdministrator() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userController");
		try{
			Administrator administrator = administratorFacade.getAdministratorByNickname(nickname);
			if (administrator.checkPassword(this.password)) {
				setCurrentAdministrator(administrator);
				return "administratorHome";
			}
			else{
				// Password Errata
				FacesContext.getCurrentInstance().addMessage("loginAdministrator:accediAdmin", new FacesMessage("Login Errato! Nickname1 o password non inseriti correttamente!"));
				return "administratorLogin";
			}
		}
		catch (Exception e) {
			// Amministratore non trovato
			FacesContext.getCurrentInstance().addMessage("loginAdministrator:accediAdmin", new FacesMessage("Login Errato! Nickname2 o password non inseriti correttamente!"));
			return "administratorLogin";
		}
	}
	
	public String createUser() {
		try{
			/*Genera automaticamente la data di oggi */
			this.registrationDate = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
			userFacade.createUser(firstName, lastName, passwordUser, email, phoneNumber, dateOfBirth, registrationDate,street, city, country, zipcode, state);
			this.message = "Registrazione utente effettuata!";
			return "registrazioneAvvenuta";
		}catch(Exception e){
			/*Utente gi√† registrato*/
			this.resetUser();
			FacesContext.getCurrentInstance().addMessage("registrationUserByAdmin:signinUserByAdmin", new FacesMessage("Utente gi‡† registrato!"));
			return "registrazioneUtenteByAdmin";
		}
	}
	
	public String deleteUser() {
		try{
			userFacade.deleteUserByEmail(email);
			this.message = "Cliente cancellato correttamente!";
			return "administratorHome";
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage("deletingUser:deleteUser", new FacesMessage("Utente inesistente!"));
			return "cancellaUtente";
		}
	}

	private void resetUser(){
		this.firstName = null;
		this.lastName = null;
		this.passwordUser = null;
		this.email = null;
		this.phoneNumber = null;
		this.street = null;
		this.city = null;
		this.state = null;
		this.zipcode = null;
		this.country = null;
		this.dateOfBirth = null;
		this.registrationDate = null;
	}
		
	public String logoutAdministrator() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index";
	}
	
	public String newPainting() {
		this.authors = authorFacade.getAllAuthors();
		return "inserimentoQuadro";
	}
	
	public String newUser() {
		return "registrazioneUtenteByAdmin";
	}
	
	public String modifyPainting() {
		this.authors = new ArrayList<>(authorFacade.getAllAuthors());
		this.painting = (Painting) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentPainting");
		return "modificaQuadro";
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Administrator getCurrentAdministrator() {
		return currentAdministrator;
	}

	public void setCurrentAdministrator(Administrator administrator) {
		this.currentAdministrator = administrator;
	}
	

	//Seguono i Getters e Setters dei dati del nuovo customer
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
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

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting painting) {
		this.painting = painting;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public AdministratorFacade getAdministratorFacade() {
		return administratorFacade;
	}

	public void setAdministratorFacade(AdministratorFacade administratorFacade) {
		this.administratorFacade = administratorFacade;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public AuthorFacade getAuthorFacade() {
		return authorFacade;
	}

	public void setAuthorFacade(AuthorFacade authorFacade) {
		this.authorFacade = authorFacade;
	}

	public PaintingFacade getPaintingFacade() {
		return paintingFacade;
	}

	public void setPaintingFacade(PaintingFacade paintingFacade) {
		this.paintingFacade = paintingFacade;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}