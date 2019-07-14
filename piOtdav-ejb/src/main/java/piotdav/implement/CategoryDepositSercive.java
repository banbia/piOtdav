package piotdav.implement;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import piotdav.entities.CategoryDeposit;
import piotdav.entities.Deposit;
import piotdav.services.ICategoryDepositService;

@Stateless
public class CategoryDepositSercive implements ICategoryDepositService {

	@PersistenceContext(unitName = "otdav-ejb")
	public EntityManager em;
	
	
	@Override
	public boolean addCategoryDeposit(CategoryDeposit C_deposit) {
		// add a new Categorydeposit
		
		try {
			if (C_deposit!= null) 
				em.persist(C_deposit);
			return true;
		}catch (Exception e){
			return false;
		}
		
	}

	@Override
	public boolean updateCategoryDeposit(CategoryDeposit C_deposit) {
		// Update Categorydeposit
		CategoryDeposit Cdep= em.find(CategoryDeposit.class, C_deposit.getIdCategoryDeposit());
		Cdep.setLibele(C_deposit.getLibele());
		
		em.persist(Cdep);	
		return true;
	}

	@Override
	public int  deleteCategoryDeposit(int idC_Deposit) {
		// Delete CategoryDeposit 
	
			em.remove(em.find(CategoryDeposit.class, idC_Deposit));
		return 1 ;
	}

	@Override
	public List<CategoryDeposit> getCategoryDeposit() {
		//get all CategoryDeposit
				TypedQuery<CategoryDeposit> query = em.createQuery("select C from CategoryDeposit C", CategoryDeposit.class);
				try
				{
					return query.getResultList();
				}
				catch (Exception e) { return null; }
				
				
				
	}

}
