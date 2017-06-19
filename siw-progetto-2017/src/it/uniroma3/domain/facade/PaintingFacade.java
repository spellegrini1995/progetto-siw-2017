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

	public Painting salva(String titolo,Integer annoRealizzazione,String dimensioni,
			String tecnica,Long idAutore,byte[] immagine){
		Painting q=new Painting();
		q.setTitolo(titolo);
		q.setAnnoRealizzazione(annoRealizzazione);
		q.setDimensioni(dimensioni);
		q.setTecnica(tecnica);
		q.setAutore(em.find(Author.class,idAutore));
		q.setImmagine(immagine);
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

	public List<String> listaTecniche(){
		TypedQuery<String> query=em.createNamedQuery("tecnicheQuadri",String.class);
		return query.getResultList();
	}

	public List<Painting> getPaintingsByAnno(Integer anno) {
		TypedQuery<Painting> query=em.createNamedQuery("quadriPerAnno",Painting.class);
		query.setParameter("anno", anno);
		return query.getResultList();
	}

	public List<Painting> getPaintingsByTecnica(String tecnica) {
		TypedQuery<Painting> query=em.createNamedQuery("quadriPerTecnica",Painting.class);
		query.setParameter("tecnica", tecnica);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Painting> getAuthorPaintings(Long id){
		Query query = em.createQuery("SELECT q FROM Painting q WHERE q.autore.id = :id");
		query.setParameter("id",  id);
		return query.getResultList();
	}
}