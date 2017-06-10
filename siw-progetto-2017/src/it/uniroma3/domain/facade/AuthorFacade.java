package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.Author;
import java.util.Date;
import java.util.List;

@Stateless
public class AuthorFacade {
	
    @PersistenceContext(unitName = "progetto-siw-unit")
    private EntityManager em;
    
	public Author createAuthor(String nome, String cognome,String nazionalità, Date dataNascita, Date dataMorte) {
		Author author = new Author(nome,cognome,nazionalità,dataNascita,dataMorte);
		em.persist(author);
		return author;
	}
	
	public Author getAuthor(Long id) {
		Author author = em.find(Author.class, id);
		return author;
	}
	
	public Author getAuthor(String nome) {
		Query q = em.createQuery("SELECT a FROM Author a WHERE a.nome = :nome");
		q.setParameter("nome", nome);
		Author a = (Author) q.getSingleResult();
		return a;
	}
	
	public List<Author> getAllAuthors() {
        CriteriaQuery<Author> cq = em.getCriteriaBuilder().createQuery(Author.class);
        cq.select(cq.from(Author.class));
        List<Author> authors = em.createQuery(cq).getResultList();
		return authors;
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
	}
