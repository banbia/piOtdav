package piotdav.implement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import piotdav.entities.Category;
import piotdav.entities.Deposit;
import piotdav.entities.Etat;
import piotdav.entities.User;
import piotdav.services.IDepositService;

@Stateless
public class DepositService implements IDepositService {
	@PersistenceContext(unitName = "otdav-ejb")
	public EntityManager em;
	
	
	@Override
	public boolean addDeposit(Deposit deposit) {
		//add a new deposit
		
		Date myDate = new Date();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
		Date Date1; 
		Date Date2;
		Date Date3;
		
		
		try {
			if (deposit != null) {
				
				Date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				Date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				Date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				deposit.setDateDebutDepot(Date1);
				deposit.setDateFinDepot(Date2);
				deposit.setDateDepot(Date3);
				deposit.setEtat("pending");
				em.persist(deposit);
				return true;
			}
		}catch (Exception e) {
			return false; }
		return false;
	}

	@Override
	public boolean updateDeposit(Deposit deposit) {
		//Update All contents of this deposit
		Deposit dep= em.find(Deposit.class, deposit.getIdDeposit());
		dep.setCategoryDep(deposit.getCategoryDep());
		dep.setWorkDeposit(deposit.getWorkDeposit());
			em.persist(dep);	
			return true;
	}

	@Override
	public boolean renewalDeposit(Deposit deposit) {
		
		// renewal the Deposit date deb, date fin
		
		
		Deposit dep= em.find(Deposit.class, deposit.getIdDeposit());
		dep.setDateDebutDepot(deposit.getDateDebutDepot());
		dep.setDateFinDepot(deposit.getDateFinDepot());
			em.persist(dep);	
			return true;
		
			
		
		
		/*Query query = em.createQuery("update Deposit d set "
				+ "dateDebutDepot=:dateDebutDepot,dateFinDepot=:dateFinDepot "
				+ " where d.idDeposit=:idDeposit", Deposit.class);
		query.setParameter("idDeposit", idDeposit);
		query.setParameter("dateDebutDepot", dateDebutDepot);
		query.setParameter("dateFinDepot", dateFinDepot);
		query.executeUpdate();*/	
	}

	@Override
	public int deleteDeposit(int idDeposit) {
		// delete this deposit
	
			
		
		em.remove(em.find(Deposit.class, idDeposit));
		return 1 ;
		
	}

	@Override
	public List<Deposit> getDeposit() {
		//get all deposit
		TypedQuery<Deposit> query = em.createQuery("select d from Deposit d", Deposit.class);
		try
		{
			return query.getResultList();
		}
		catch (Exception e) { return null; }
		
	}

	@Override
	public int revocDeposit(int idDeposit) {
		// refuse this deposit (chage etat)
		
		try {
		
			Deposit depF= em.find(Deposit.class, idDeposit);
			depF.setEtat("Refuse");
		
			em.persist(depF);
			return 1;
		}catch ( Exception e ){
			return -1;}
	}

	@Override
	public List<Deposit> getDepositByAdherent(int idUser) {
		//Get all deposits by adherent

		TypedQuery<Deposit> query = em.createQuery(
				"select d FROM Deposit d WHERE d.user.idUser = :user", Deposit.class);
		query.setParameter("user", idUser);

		return query.getResultList();
	}
	

	@Override
	public List<Deposit> getDepositByCategorie(int categoryDeposit) {
		//Get all getDeposit By Categorie
		
		TypedQuery<Deposit> query = em.createQuery(
				"select d FROM Deposit d WHERE d.categoryDeposit.idCategoryDep = :categoryDeposit", Deposit.class);
		query.setParameter("categoryDeposit",categoryDeposit );
		
			return query.getResultList();
				
	}

}
