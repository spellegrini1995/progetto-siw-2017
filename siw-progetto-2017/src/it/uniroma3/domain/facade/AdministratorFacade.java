package it.uniroma3.domain.facade;

import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.Administrator;


@Stateless(name="administratorFacade")
public class AdministratorFacade {
	
    @PersistenceContext(unitName = "progetto-siw-unit")
    private EntityManager em;
    
	public Administrator createAdministrator(String nome, String cognome, String username, String password) {
		Administrator administrator = new Administrator(nome, cognome, username, password);
		em.persist(administrator);
		return administrator;
	}
	
	public Administrator getAdministratorByUsername(String username) {
		Query q = em.createQuery("SELECT a FROM Administrator a WHERE a.username = :username");
		q.setParameter("username", username);
		Administrator administrator = (Administrator) q.getSingleResult();
		return administrator;
	}
	
	public void updateAdministrator(Administrator administrator) {
        em.merge(administrator);
	}
	
    private void deleteAdministrator(Administrator administrator) {
        em.remove(administrator);
    }

	public void deleteAdministrator(Long id) {
        Administrator administrator = em.find(Administrator.class, id);
        deleteAdministrator(administrator);
	}
	
	public List<Administrator> getAllAdministrators() {
        CriteriaQuery<Administrator> cq = em.getCriteriaBuilder().createQuery(Administrator.class);
        cq.select(cq.from(Administrator.class));
        List<Administrator> administrators = em.createQuery(cq).getResultList();
		return administrators;
	}
}