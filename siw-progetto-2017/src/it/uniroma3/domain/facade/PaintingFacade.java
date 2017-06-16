package it.uniroma3.domain.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;



@Stateless(name="paintingFacade")

public class PaintingFacade {

	@PersistenceContext(unitName = "progetto-siw-unit")
	private EntityManager em;
	
	public Painting salva(Painting q, Long idAutore) {
		q.setAutore(em.find(Author.class, idAutore));
		em.persist(q);
		return q;
	}
	
	public Painting find(Long id){
		return em.find(Painting.class,id);
	}
	public List<Painting> getAll(){
		TypedQuery<Painting> query=em.createNamedQuery("tuttiIQuadri",Painting.class);
		return query.getResultList();
	}	
	public Painting getPaintingByTitolo(String titolo){
			Query q = em.createQuery("SELECT c FROM Painting c WHERE c.titolo = :titolo");
			q.setParameter("titolo", titolo);
			Painting p = (Painting) q.getSingleResult();
			return p;
	}
	public void remove(Long id){
		Painting q=this.find(id);
		em.remove(q);
		return;
	}
	public Painting merge(Painting q,Long idAutore){
		Author nuovo=this.em.find(Author.class,idAutore);
		q.setAutore(nuovo);
		return em.merge(q);
	}
	public Painting merge(Painting q){
		return em.merge(q);
	}
	public List<Integer> listaAnni(){
		TypedQuery<Integer> query=em.createNamedQuery("anniQuadri",Integer.class);
		return query.getResultList();
	}

	public List<Painting> getQuadriPerAutore(Long idAutore) {
		TypedQuery<Painting> query= em.createNamedQuery("quadriPerAutore",Painting.class);
		query.setParameter("idAutore",idAutore);
		return query.getResultList();
	}
}