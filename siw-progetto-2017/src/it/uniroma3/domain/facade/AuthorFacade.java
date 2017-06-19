package it.uniroma3.domain.facade;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import it.uniroma3.domain.model.Author;
import java.util.Date;
import java.util.List;

@Stateless(name="authorFacade")
public class AuthorFacade {

	@PersistenceContext(unitName = "progetto-siw-unit")
	private EntityManager em;

	public Author createAuthor(String nome, String cognome,String nazionalita, Date dataNascita, Date dataMorte) {
		Author author = new Author(nome,cognome,nazionalita,dataNascita,dataMorte);
		em.persist(author);
		return author;
	}

	public Author getAuthor(Long id) {
		Author author = em.find(Author.class, id);
		return author;
	}

	public Author getAuthor(String nome, String cognome) {
		Query q = em.createQuery("SELECT a FROM Author a WHERE a.nome = :nome and a.cognome = :cognome");
		q.setParameter("nome", nome);
		q.setParameter("cognome", cognome);
		Author a = (Author) q.getSingleResult();
		return a;
	}

	public List<Author> getAllAuthors() {
		TypedQuery<Author> query=em.createNamedQuery("findAllAuthors",Author.class);
		return query.getResultList();
	}

	public void updateAuthor(Author author) {
		em.merge(author);
	}

	public Author updateAuthor(Long id) {
		Author author = em.find(Author.class, id);
		updateAuthor(author);
		return author;
	}

	private void deleteAuthor(Author author) {
		em.remove(author);
	}

	public void deleteAuthor(Long id) {
		Author author = em.find(Author.class, id);
		deleteAuthor(author);
	}

	public Author getByNameAuthor(String nome, String cognome){
		Query query = em.createQuery("SELECT a FROM Author a WHERE a.nome =:nome AND a.cognome:=cognome");
		query.setParameter("nome",  nome);
		query.setParameter("cognome",  cognome);
		return (Author)query.getSingleResult();
	}

	public List<String> listaNazioni(){
		TypedQuery<String> query=em.createNamedQuery("nazioniAutori",String.class);
		return query.getResultList();
	}
}
