package it.uniroma3.services.controller;

import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import it.uniroma3.domain.facade.AddressFacade;
import it.uniroma3.domain.model.Address;

@ManagedBean(name="addressController")
@SessionScoped
public class AddressController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String via;
	private String comune;
	private String provincia;
	private String codicePostale;
	private String nazione;
	private Address address;
	private List<Address> addresses;
	
	@EJB
	private AddressFacade addressFacade;
	
	
	public String deleteAddress(){
		addressFacade.deleteAddress(id);
		this.addresses = addressFacade.getAllAddresses();
		return "orders";
	}
	
	public String updateAddress(){
		this.address = addressFacade.getAddress(id);
		return "update";
	}
		
	public String createAddress(){
		this.address = addressFacade.createAddress(via, comune, provincia, codicePostale, nazione);
		return "address";
	}
	
	public String listAddress() {
		this.addresses = addressFacade.getAllAddresses();
		return "addresses"; 
	}

	public String findAddress() {
		this.address = addressFacade.getAddress(id);
		return "address";
	}
	
	public String findAddress(Long id) {
		this.address = addressFacade.getAddress(id);
		return "address";
	}

	//getter and setter
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public AddressFacade getAddressFacade() {
		return addressFacade;
	}

	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}
}

