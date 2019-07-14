package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import piotdav.entities.Resignation;
import piotdav.services.IResignationService;
@Stateless
public class ResignationService implements IResignationService{
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;

	@Override
	public boolean addResignation(Resignation resignation) {
		em.persist(resignation);

		return true;
		
	}

	@Override
	public Resignation getResignationById(int id) {
		Resignation resignation = em.find(Resignation.class, id);

		return resignation;
	}

	@Override
	public Resignation getResignationByIdUser(int id) {
		//try {
			Query query = em.createQuery("select e from resignation e where e.user.idUser=:l");
			query.setParameter("l", id);
			return (Resignation) query.getSingleResult();
		//} catch (Exception e) {
		//	return null;
		//}
		
	}

	@Override
	public List<Resignation> getAll() {
		List<Resignation> Resignations = em.createQuery("select u from Resignation u",Resignation.class).getResultList();
		return Resignations;
	}

}
