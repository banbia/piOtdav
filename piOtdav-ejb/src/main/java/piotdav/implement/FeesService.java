package piotdav.implement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import piotdav.entities.Fees;
import piotdav.entities.User;
import piotdav.services.IFeesService;
@Stateless
public class FeesService implements IFeesService {
	private List<Fees> feeses;
	@PersistenceContext(unitName = "otdav-ejb")
	EntityManager em;
	
	public List<Fees> getFeeses() {
		return feeses;
	}

	public void setFeeses(List<Fees> feeses) {
		this.feeses = feeses;
	}

	@Override
	public boolean addFees(Fees fees) {
		em.persist(fees);
		return true;	
	}

	@Override
	public void updateFees(Fees fees) {
		em.persist(fees);
	}

	@Override
	public Fees findFeesById(int idFees) {
		Fees feesToFind = em.find(Fees.class, idFees);
		return feesToFind;
	}

	@Override
	public void deleteFess(Fees fees) {
		em.remove(fees);
		
	}

	@Override
	public List<Fees> getFees() {
		return feeses;
	}

	@Override
	public Fees getFeesByUser(User user) {	
		TypedQuery<Fees> query = em.createQuery("SELECT * from Fees  WHERE idUser=:user.idUser",Fees.class);
		query.setParameter("iduser", user.getIdUser());
		return (Fees) query.getResultList();
	}

}
