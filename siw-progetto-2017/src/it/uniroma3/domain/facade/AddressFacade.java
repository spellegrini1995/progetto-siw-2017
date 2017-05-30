package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.Address;

import java.util.List;

@Stateless
public class AddressFacade {
	
    @PersistenceContext(unitName = "progetto-siw")
    private EntityManager em;
    
	public Address createAddress(String street, String city, String state, String zipcode, String country) {
		Address address = new Address(street, city, state, zipcode, country);
		em.persist(address);
		return address;
	}
	
	public Address getAddress(Long id) {
		Address address = em.find(Address.class, id);
		return address;
	}
	
	public List<Address> getAllAddresses() {
        CriteriaQuery<Address> cq = em.getCriteriaBuilder().createQuery(Address.class);
        cq.select(cq.from(Address.class));
        List<Address> addresses = em.createQuery(cq).getResultList();
		return addresses;
	}

	public void updateAddress(Address address) {
        em.merge(address);
	}
		
    private void deleteAddress(Address address) {
        em.remove(address);
    }

	public void deleteAddress(Long id) {
		Address address = em.find(Address.class, id);
        deleteAddress(address);
	}
		
}
