package it.uniroma3.domain.controller;

import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.uniroma3.domain.facade.UserFacade;
import it.uniroma3.domain.model.Address;
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
	private Address address;
	
	private User user;
	private List<User> users;

	@EJB
	private UserFacade userFacade;
	
	
	@ManagedProperty(value="#{addressController}")
    private AddressController addressController;
	

	public AddressController getAddressController() {
		return addressController;
	}

	public void setAddressController(AddressController addressController) {
		this.addressController = addressController;
	}

	public String deleteUser(){
		userFacade.deleteUser(id);
		this.users = userFacade.getAllUsers();
		return "users";
	}

	public String createUser() {
		this.address = this.addressController.getAddress();
		this.user = userFacade.createUser(nome,cognome,email,password);
		return "userHome"; 
	}

	public String listUsers() {
		this.users = userFacade.getAllUsers();
		return "users"; 
	}

	public String findUser() {
		this.user = userFacade.getUser(id);
		return "users";
	}

	public String findUser(Long id) {
		this.user = userFacade.getUser(id);
		return "user";
	}

	public String userLogin(){
		String nextPage = "loginError";
		try{ 
			User user = userFacade.checkEmail(email);
			if(user.checkPassword(this.password)){
				this.user = user;
				return "userHome";
			}
		}
		catch (Exception e){
		}
		return nextPage;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
}
