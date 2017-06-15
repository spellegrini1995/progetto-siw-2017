package it.uniroma3.domain.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public void remove(Long id){
		Painting q=this.find(id);
		em.remove(q);
		return;
	}
	public Painting merge(Painting q){
		return em.merge(q);
	}
	public List<Integer> listaAnni(){
		TypedQuery<Integer> query=em.createNamedQuery("anniQuadri",Integer.class);
		return query.getResultList();
	}
}