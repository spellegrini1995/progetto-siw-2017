package it.uniroma3.domain.facade;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.domain.model.Administrator;

@Stateless
public class AdministratorFacade {
	@PersistenceContext(unitName= "progetto-siw")
	private EntityManager em;
	
	public Administrator createAdministrator(String firstName, String lastName, String email, String password){
		Administrator administrator = new Administrator(firstName, lastName, email, password);
		em.persist(administrator);
		return administrator;
	}

	public Administrator getAdministratorByMail(String email) {
		Administrator administrator = em.find(Administrator.class, email);
		return administrator;
	}
	
	public Administrator getAmministratore(Long id){
		Administrator amministratore = em.find(Administrator.class, id);
		return amministratore;
	}
	
	public Administrator checkEmail(String email){
		Query query = em.createQuery("SELECT a FROM Administrator a WHERE a.email =:email");
		query.setParameter("email",  email);
		return (Administrator)query.getSingleResult();
	}

}