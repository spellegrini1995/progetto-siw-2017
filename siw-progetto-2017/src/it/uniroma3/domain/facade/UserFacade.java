package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.uniroma3.domain.model.Address;
import it.uniroma3.domain.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Stateless(name="userFacade")
public class UserFacade{

	@PersistenceContext(unitName = "progetto-siw-unit")
	private EntityManager em;

	public User createUser(String nome, String cognome, String password, String email, String numeroTelefono, Date dataNascita, Calendar dataRegistrazione, String street, String city, String country, String zipcode, String state) {
		Address address = new Address(street, city, country, zipcode, state);
		em.persist(address);
		User user = new User(nome, cognome, password, email, numeroTelefono, dataNascita, dataRegistrazione, address);
		em.persist(user);
		return user;
	}

	public User getUserByEmail(String email) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
		q.setParameter("email", email);
		User user = (User) q.getSingleResult();
		return user;
	}

	public List<User> getAllUsers() {
		TypedQuery<User> query=em.createNamedQuery("findAllUsers",User.class);
		return query.getResultList();
	}

	public void updateUser(User User) {
		em.merge(User);
	}

	private void deleteUser(User user) {
		em.remove(user);
	}

	public void deleteUser(Long id) {
		User user = em.find(User.class, id);
		deleteUser(user);
	}

	public void deleteUserByEmail(String email) {
		User user = this.getUserByEmail(email);
		deleteUser(user);
	}

	public User getUser(String email) {
		User user = em.find(User.class, email);
		return user;	
	}
}