package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.User;

import java.util.List;

@Stateless
public class UserFacade {

	@PersistenceContext(unitName = "progetto-siw")
	private EntityManager em;

	public User createUser(String firstName, String lastName, String email, String password) {
		User user = new User(firstName,  lastName,  email, password);
		em.persist(user);
		return user;
	}

	public User getUser(Long id) {
		User user = em.find(User.class, id);
		return user;
	}

	public List<User> getAllUsers() {
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		cq.select(cq.from(User.class));
		List<User> users = em.createQuery(cq).getResultList();
		return users;
	}

	public void updateUser(User user) {
		em.merge(user);
	}

	public User updateUser(Long id) {
		User user = em.find(User.class, id);
		updateUser( user);
		return user;
	}

	private void deleteUser(User user) {
		em.remove(user);
	}

	public void deleteUser(Long id) {
		User user = em.find(User.class, id);
		deleteUser(user);
	}

	public User checkEmail(String email){
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email =:email");
		query.setParameter("email",  email);
		return (User)query.getSingleResult();
	}
	
	
	
	
}