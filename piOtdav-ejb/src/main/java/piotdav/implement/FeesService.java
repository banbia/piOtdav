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
	public boolean updateFees(Fees fees) {
		Fees fee = em.find(Fees.class, fees.getIdFees());
		fee.setMontant(fees.getMontant());
		em.persist(fee);
		return true ;
	}

	@Override
	public Fees findFeesById(int idFees) {
		Fees feesToFind = em.find(Fees.class, idFees);
		return feesToFind;
	}

	@Override
	public boolean  deleteFees(int idFees) {
		em.remove(em.find(Fees.class, idFees));
		return true;
		
	}

	
	@Override
	public List<Fees> listFees(int idUser) {
		TypedQuery<Fees> query = em.createQuery(
				"SELECT u FROM Fees u WHERE u.user.idUser = :user ", Fees.class);
		query.setParameter("user", idUser);
		return query.getResultList();
	}
	@Override
	public Fees getFeesByUser(User user) {	
		TypedQuery<Fees> query = em.createQuery(
				"SELECT u FROM Notification u WHERE u.user.idUser = :user",Fees.class);		
		query.setParameter("iduser", user.getIdUser());
		return (Fees) query.getResultList();
	}

}
