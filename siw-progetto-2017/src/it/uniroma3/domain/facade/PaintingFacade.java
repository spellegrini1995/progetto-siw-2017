package it.uniroma3.domain.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.domain.model.Author;
import it.uniroma3.domain.model.Painting;

import java.util.List;

@Stateless
public class PaintingFacade {
	
    @PersistenceContext(unitName = "progetto-siw")
    private EntityManager em;
    
	public Painting createPainting(String titolo,Integer anno, String tecnica,String dimensioni,Author autore) {
		Painting painting = new Painting(titolo, anno,tecnica, dimensioni,autore);
		em.persist(painting);
		return painting;
	}
	
	public Painting getPainting(Long id) {
	    Painting Painting = em.find(Painting.class, id);
		return Painting;
	}
	
	public List<Painting> getAllPaintings() {
        CriteriaQuery<Painting> cq = em.getCriteriaBuilder().createQuery(Painting.class);
        cq.select(cq.from(Painting.class));
        List<Painting> paintings = em.createQuery(cq).getResultList();
		return paintings;
	}

	public void updatePainting(Painting painting) {
        em.merge(painting);
	}
	
	public Painting updatePainting(Long id) {
		Painting painting = em.find(Painting.class, id);
		updatePainting(painting);
		return painting;
	}
	
    private void deletePainting(Painting painting) {
        em.remove(painting);
    }

	public void deletePainting(Long id) {
        Painting painting = em.find(Painting.class, id);
        deletePainting(painting);
	}
		
	public Painting getByNamePainting(String titolo){
			Query query = em.createQuery("SELECT p FROM Painting p WHERE p.titolo =:titolo");
			query.setParameter("titolo",  titolo);
			return (Painting)query.getSingleResult();
	}
	
	
	
	
}