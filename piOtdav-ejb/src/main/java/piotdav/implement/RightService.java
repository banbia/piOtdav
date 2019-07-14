package piotdav.implement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import piotdav.entities.Notification;
import piotdav.entities.Right;
import piotdav.entities.Work;
import piotdav.services.IRightService;
@Stateless
public class RightService implements IRightService{
	
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;
	
	public boolean addRight(Right right){
		  em.persist(right);
		 return true;
	}
	public boolean updateRight(Right right){
		Right r = em.find(Right.class, right.getIdRight());
		if(r.getWorks().isEmpty()) {
			if(right.getDescription()!=null)
				r.setDescription(right.getDescription());
			if(right.getLibele()!=null)
				r.setLibele(right.getLibele());
			if(right.getReference()!=null)
				r.setReference(right.getReference());
			
			em.persist(r);
			return true;
		}
		return false;
	}
	
	public boolean deleteRight(int idRight){
		Right right = em.find(Right.class, idRight);
		if(right.getWorks().isEmpty()) {
			em.remove(right);
			return true;
		}
		return false;
	}
	@Override
	public Right getRightByReference(String reference) {
		TypedQuery<Right> query = em.createQuery(
				"Right u FROM Right u WHERE u.reference = :ref ", Right.class);
		query.setParameter("ref", reference);
		return query.getSingleResult();
	}
	@Override
	public List<Right> getRightsByWork(int workId) {
//		User user = em.find(User.class, idUser);
		Work work = em.find(Work.class, workId);
		return (List<Right>) work.getRights();
	}
	@Override
	public boolean linkRightsToWork(int idRight, int idWork) {
		Right right = em.find(Right.class, idRight);
		Work work = em.find(Work.class, idWork);
		List<Right> liste = this.getRightsByWork( idWork);
		if (liste.contains(right)) {
			return false;
		}
		liste.add(right);
		work.setRights(liste);
		em.persist(work);
		return true;
	}

}
