package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.Address;
import it.uniroma3.domain.model.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

	@Stateless(name="userFacade")
	public class UserFacade{
		
	    @PersistenceContext(unitName = "progetto-siw")
	    private EntityManager em;
	    
		public User createUser(String firstName, String lastName, String password, String email, String phoneNumber, Date dateOfBirth, Calendar registrationDate, String street, String city, String country, String zipcode, String state) {
			Address address = new Address(street, city, country, zipcode, state);
			em.persist(address);
			User user = new User(firstName, lastName, password, email, phoneNumber, dateOfBirth, registrationDate, address);
			em.persist(user);
			return user;
		}
		
		public User getUserByEmail(String email) {
			Query q = em.createQuery("SELECT c FROM User c WHERE c.email = :email");
			q.setParameter("email", email);
			User user = (User) q.getSingleResult();
			return user;
		}
		
		public List<User> getAllUsers() {
	        CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
	        cq.select(cq.from(User.class));
	        List<User> users = em.createQuery(cq).getResultList();
			return users;
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